package com.feiyu.data.practise.base.tools;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xzhou.James
 * @Date 2020/6/29  22:04
 */
public class LogTest {

    private static  final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void TestClass(){
        float a = 3.4F;
        double b = 3.455;
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("column_0","Java");
        map.put("column_1",36555556.25);
        map.put("column_2","Python");
        map.put("column_3",15854858585.25);
        list.add(map);
        logger.info("TestClass.list{},结尾字符,b{}",list.get(0),b);
        logger.info("TestClass.list:"+list.get(0));

        String temp = "5456456456545.26";
        String str = "5555888888885555555555555555588888";
        double d = Double.parseDouble(temp);
        double e = Double.parseDouble(str);
        System.out.println("d:"+d);
        System.out.println("e:"+e);
    }

}
