package com.feiyu.data.excel.easyexcel.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.feiyu.data.excel.easyexcel.lister.ExcelLister;
import com.feiyu.data.excel.easyexcel.model.Car;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/16  20:07
 */
public class TestExcel {

    private Logger logger = LoggerFactory.getLogger(TestExcel.class);

    @Test
    public void TestExcelRead() throws Exception{
        String path = "D:\\person\\infos.xlsx";
        if(StringUtils.isNotEmpty(path)){
            readExcel(path);
        }
    }

    private void readExcel(String path) throws Exception{
        try{
            Sheet sheet = new Sheet(1,1,Car.class);
            EasyExcelFactory.readBySax(new FileInputStream(path),sheet,new ExcelLister());
            /*List<Object> carList = EasyExcelFactory.read(new FileInputStream(path),sheet);
            for(Object obj:carList) {
                if(obj instanceof Car){
                    Car car = (Car)obj;
                    System.out.println(car);
                }
            }*/
        }catch (Exception ex){
            logger.error("异常信息");
        }
    }

    @Test
    public void testExcel01(){
        String a = "";
        String b = "hello";

        if(StringUtils.isNotEmpty(b) && StringUtils.isEmpty(a)){
            System.out.println("a<>"+a+"b<>"+b);
        }else{
            System.out.println("error");
        }
    }

    @Test
    public void TestStringReplace(){
        String flag = "vivo";
        String result = flag.replace(flag,"oppo");
        String test = "huawei";
        String string = test.replace(test,"xiaomi");
        //test.replace(oldChar,newChar);
        System.out.println(result);
    }
}
