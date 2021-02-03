package com.feiyu.data.excel.jxl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou.James on 2020/2/15
 */
public class PersonInfos {

    private static Logger logger = LoggerFactory.getLogger(PersonInfos.class);

    private final static String url = "http://wwww.youjxl.com.cn";

    public static void main(String[] args) throws Exception {
        try {
            Workbook workbook = null;
            //Sheet sheet = null;
            int i = 0;
            File file = new File("D:/person/infos.xls");
            if(!file.exists()){
                logger.error("文件不存在！");
            }
            createFile(workbook,i,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFile(Workbook workbook, int i, File file)throws Exception {
        workbook = Workbook.getWorkbook(file);
        //List<String> allList = new ArrayList<String>();
        Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        lable:
        while (map.size() == 0){
            Sheet[] strings = workbook.getSheets();
            if(null == strings){
                break;
            }
            for (int j = 0; j < strings.length; j++) {
                Sheet sheets = strings[j];
                if(null == sheets){
                    break lable;
                }
                Cell[] cellColumns =  sheets.getColumn(i);//行信息
                if(null != cellColumns){
                    for (int r = 1; r < cellColumns.length; r++) {
                        Cell[] cellRows =  sheets.getRow(i);//列信息
                        List<String> stringList = new ArrayList<String>();
                        for (int c = 0; c < cellRows.length; c++) {
                            Cell cell = sheets.getCell(c,r);
                            String cellContents =  cell.getContents();
                            stringList.add(cellContents);
                            System.out.println("单元格内容展示:"+cell.getContents());
                            if(null == cell){
                                break lable;
                            }
                        }
                        map.put(0,stringList);
                        //填充数据
                        putData(map);
                    }
                }
            }
        }
        workbook.close();
    }

    private static void putData(Map<Integer,List<String>> mapData) {
        //Person person = new Person();
        if(mapData.size() > 0){
            List<String> stringList = mapData.get(0);
            Person person = new Person();
            if(CollectionUtils.isNotEmpty(stringList)){
                List<Person> personList = new ArrayList<Person>();
                for (int i = 0; i < stringList.size(); i++) {
                    switch (i) {
                        case 0:
                            person.setUserName(stringList.get(i));
                            continue;
                        case 1:
                            person.setUserAge(stringList.get(i));
                            continue;
                        case 2:
                            person.setUserSex(stringList.get(i));
                            continue;
                        case 3:
                            person.setUserStation(stringList.get(i));
                            continue;
                        default:
                            System.out.println("暂无");
                            break;
                    }
                }
                personList.add(person);
                convertJson(personList);
            }
        }else{
            logger.error("集合数据为空！");
        }
    }

    //将数据转化为Json
    private static void convertJson(List<Person> person) {
        if(person != null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user_name",person.get(0).getUserName());
            jsonObject.put("user_age",person.get(0).getUserAge());
            jsonObject.put("user_sex",person.get(0).getUserSex());
            jsonObject.put("user_station",person.get(0).getUserStation());
            //转化为Json
            String data = jsonObject.toJSONString();
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(data);
            JSONObject jsonData = new JSONObject();
            jsonData.put("person",jsonArray);
            String result = jsonData.toJSONString();
            System.out.println("转化为Json格式:"+result);
        }
    }
}
