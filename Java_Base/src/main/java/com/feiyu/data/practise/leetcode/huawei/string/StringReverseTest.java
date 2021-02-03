package com.feiyu.data.practise.leetcode.huawei.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by xzhou.James on 2020/12/29
 */
public class StringReverseTest {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            String result = getReverse(str);
            System.out.println("result = " + result);
        }
    }

    private static String getReverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
