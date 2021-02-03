package com.feiyu.data.ocean.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xzhou.James
 * @Date 2019/12/8  14:55
 */
public class DateFormatUtils {

    public String formatDate(String inputDate) throws Exception{
        String date = "2018/11/26 8:21:51";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat parse = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date time = parse.parse(date);
        String result = sdf.format(time);
        System.out.println(result);

        return result;
    }
}
