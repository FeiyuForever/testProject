package com.feiyu.data.ocean.utils;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class LongTextConverter {

    /**
     * 处理大数据(单行记录时)
     *
     * @param resultSet      Map<String, Object> 结果集
     * @param aliasRealNames 别名,实名的字典 比如：("newsDetail":"reportDetail","cash":"money")
     */
    public static void getLongTextValue(Map<String, Object> resultSet,
                                        Map<String, String> aliasRealNames, SqlSessionFactory sqlSessionFactory) {


        if(null == resultSet){
            return;
        }

        List<Map<String, Object>> resultSets= new ArrayList<Map<String, Object>>();
        resultSets.add(resultSet);
        LongTextConverter.getLongTextValue(resultSets,null,sqlSessionFactory);
    }

    /**
     * 处理大数据(单行记录时)(确定字段是大数据字段时传入)
     *
     * @param resultSet      Map<String, Object> 结果集
     * @param aliasRealNames 别名,实名的字典 比如：("newsDetail":"reportDetail","cash":"money")
     */
    public static void getEnsureLongTextTextValue(List<String> keyList,Map<String, Object> resultSet,
                                        Map<String, String> aliasRealNames, SqlSessionFactory sqlSessionFactory) {


        if (null == resultSet || 0 == resultSet.size()) {
            return;
        }



        //从redis取保存的longtext的字段名
        List<String> longTextColumnsKeys = new ArrayList<String>();
        for(String key:keyList){
            longTextColumnsKeys.add(key);
        }

        List<Map<String, Object>> resultSets= new ArrayList<Map<String, Object>>();
        resultSets.add(resultSet);
        preCleanData(longTextColumnsKeys,resultSets,aliasRealNames, sqlSessionFactory);

        System.out.println(resultSet);


    }


    private static List<String>  getLongTextColumnsName(SqlSessionFactory sqlSessionFactory) {
        //从redis取保存的longtext的字段名
        List<String> longTextColumnsKeys = new ArrayList<String>();


        Map<String, DataSource> dataSources = new HashMap<String, DataSource>();

        try {
            dataSources = (Map<String, DataSource>) getPrivateField((sqlSessionFactory.getConfiguration().getEnvironment().getDataSource()),
                    "targetDataSources");
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException：" + e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException：" + e.toString());
            e.printStackTrace();
        }


        //保存的longtext字段名的数据库
        Connection longtextConnection = null;
        try {

            for (Map.Entry<String, DataSource> dataSourceEntry : dataSources.entrySet()) {
                longtextConnection = dataSourceEntry.getValue().getConnection();
                if ("wind_wfcenterprise_db".equals(longtextConnection.getCatalog())) {
                    break;
                } else {
                    longtextConnection.close();
                }
            }

            //redis 取不到时从mysql取
            if (null == longTextColumnsKeys || 0 == longTextColumnsKeys.size()) {

                String longtextCacheTableName = "textcolumns";

                Statement statement = longtextConnection.createStatement();
                statement.execute("select columnName from " + longtextCacheTableName);
                ResultSet resultSetSql = statement.getResultSet();

                while (resultSetSql.next()) {
                    longTextColumnsKeys.add(resultSetSql.getString(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e2) {
            System.out.println(e2.toString());
        } finally {
            //Conection关闭
            try {

                if(null != longtextConnection){
                    longtextConnection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return longTextColumnsKeys;

    }

    private static void preCleanData(List<String> longTextColumnsKeys,List<Map<String, Object>> resultSet,
                                     Map<String, String> aliasRealNames, SqlSessionFactory sqlSessionFactory){
        Connection connection = null;
        try {

            //本库
            connection = sqlSessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection();

//		String pre = "ET_LongText:";
            String pre = "";

            //如果为空，初始化一个，方便处理
            if (null == aliasRealNames) {
                aliasRealNames = new HashMap<String, String>(2);
            }

            //判断 传入的 结果里面有没有 longtext字段
            Map<String, String> aliasRealTemp = new HashMap<String, String>();
            Set<String> keys = resultSet.get(0).keySet();
            Iterator<String> keysIterator = keys.iterator();
            while (keysIterator.hasNext()) {
                String column = keysIterator.next();
                //缓存里存在且 不在别名map的key里时
                if (longTextColumnsKeys.contains(pre + column)
                        && !aliasRealNames.containsKey(column)) {
                    aliasRealTemp.put(column, column);
                } else if (longTextColumnsKeys.contains(pre + aliasRealNames.get(column))) {
                    //别名传入时
                    aliasRealTemp.put(column, aliasRealNames.get(column));
                }

            }

            //如果不存在longtext字段
            if (0 == aliasRealTemp.size()) {
                return;
            }

            //找到所有 带¤¤¤¤的值并做处理
            for (Map.Entry<String, String> aliasRealName : aliasRealTemp.entrySet()) {

                String alias = aliasRealName.getKey();
                String realName = aliasRealName.getValue();

                Map<String, List<String>> tableKeysMap = new HashMap<String, List<String>>();
                //第几行哪个key是¤¤¤¤开头的记录
                Map<String, String> lineNoAndKey = new HashMap<String, String>();
                for (int index = 0; index < resultSet.size(); index++) {

                    Map<String, Object> oneRecord = resultSet.get(index);

                    String value = oneRecord.get(alias).toString();

                    //【¤¤¤¤WIND¤TB_OBJECT_6461¤{5D7329B5-A3CC-9C83-E053-3602C80A51EF}】
                    if (value.startsWith("¤¤¤¤")) {

                        String[] sunSplits = value.split("¤");

                        if (sunSplits.length > 1) {

                            String tableName = sunSplits[5];
                            String key = sunSplits[6];

                            lineNoAndKey.put(key, alias + ":" + index);

                            if (tableKeysMap.containsKey(tableName)) {
                                List<String> keyList = tableKeysMap.get(tableName);
                                keyList.add(key);
                            } else {
                                List<String> keyList = new ArrayList<String>();
                                tableKeysMap.put(tableName, keyList);
                                keyList.add(key);
                            }

                        }

                    } else {
                        continue;
                    }

                }

                if (0 == tableKeysMap.size()) {
                    continue;
                }

                convertData(resultSet, tableKeysMap, lineNoAndKey, connection);

            }


        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e2) {
            System.out.println(e2.toString());
        } finally {
            //Conection关闭
            try {

                if(null != connection){
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 处理大数据(多行记录)
     *
     * @param resultSet      List<Map<String, Object>> 结果集
     * @param aliasRealNames 别名,实名的字典 比如：("newsDetail":"reportDetail","cash":"money")
     */
    public static void getLongTextValue(List<Map<String, Object>> resultSet,
                                 Map<String, String> aliasRealNames, SqlSessionFactory sqlSessionFactory) {

        if (null == resultSet || 0 == resultSet.size()) {
            return;
        }

        //从redis取保存的longtext的字段名
        List<String> longTextColumnsKeys = getLongTextColumnsName(sqlSessionFactory);
        if(null == longTextColumnsKeys || longTextColumnsKeys.size() == 0){
            return;
        }

        preCleanData(longTextColumnsKeys,resultSet,aliasRealNames, sqlSessionFactory);

        System.out.println(resultSet);

    }


    private static Object getPrivateField(Object instance, String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getSuperclass().getDeclaredField(filedName);
        field.setAccessible(true);
        return field.get(instance);

    }

    /**
     *
     * 转换数据
     * @param resultSet
     * @param tableKeysMap
     * @param lineNoAndKey
     * @param connection
     * @throws SQLException
     */
    private static void convertData(List<Map<String, Object>> resultSet, Map<String, List<String>> tableKeysMap, Map<String, String> lineNoAndKey, Connection connection) throws SQLException {

        String sunSql = "select * from StoneDBForWFC.%s where ob_object_id in (%s)";


        for (Map.Entry<String, List<String>> entry : tableKeysMap.entrySet()) {
            String tableName = entry.getKey();
            List<String> keys = entry.getValue();

            //TB_OBJECT_6461
            String tableNameSplit[] = tableName.split("_");
            String columnName = "F5_"+tableNameSplit[tableNameSplit.length - 1];


            StringBuffer inKeys = new StringBuffer();
            for (String key : keys) {
                inKeys.append("\'");
                inKeys.append(key);
                inKeys.append("\'");
                inKeys.append(",");
            }

            inKeys.append("\'&&&&NORRCORDE&&&&\'");

            //执行数据库操作
            sunSql = String.format(sunSql, tableName, inKeys.toString());
            Statement statement = connection.createStatement();
            statement.execute(sunSql);
            ResultSet resultSetSql = statement.getResultSet();

            //真值设定
            while (resultSetSql.next()) {
                String realvalue = resultSetSql.getString(columnName);
                String ob_object_id = resultSetSql.getString("ob_object_id");
                //alias+":"+index
                String aliasIndexStr = lineNoAndKey.get(ob_object_id);
                String[] aliasIndex = aliasIndexStr.split(":");
                String alias = aliasIndex[0];
                int index = Integer.valueOf(aliasIndex[1]);

                Map<String, Object> onRecordOfIndex = resultSet.get(index);
                onRecordOfIndex.put(alias, realvalue);

            }

            statement.close();


        }


    }

}
