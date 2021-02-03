package com.feiyu.data.practise.leetcode.huawei.datetime;

import jxl.write.DateTime;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by xzhou.James on 2021/2/1
 *
 * 1.8时间操作方法
 */
public class DateTimeOptional {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        //原始的时间
        System.out.println("localDateTime = " + localDateTime.toString());
        //基本的格式时间
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println("formatter-localDateTime = " + localDateTime.format(formatter));
        //格式为 yyyy年MM月dd日 + 星期
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("formatter1-localDateTime = " + localDateTime.format(formatter1));
        //格式为 yyyy年MM月dd日
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println("formatter2-localDateTime = " + localDateTime.format(formatter2));
        //格式为 yyyy-MM-dd
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("formatter3-localDateTime = " + localDateTime.format(formatter3));
        //格式为 yy-MM-dd
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println("formatter4-localDateTime = " + localDateTime.format(formatter4));
    }

    @Test
    public void TestDateTime(){
        LocalDateTime max = LocalDateTime.MAX;
        System.out.println("max = " + max);
        LocalDateTime min = LocalDateTime.MIN;
        System.out.println("min = " + min);
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate.toString());
    }
}
