package com.feiyu.data.practise.test.sort;

import java.io.*;

/**
 * @Author xzhou.James
 * @Date 2020/7/19  11:08
 *
 * 给定一个字符串 按照ascll码值进行排序
 */
public class CharSort {
    public static void main(String[] args) throws Exception{
        /*int temp = 97;
        char ch = (char)temp;
        System.out.println(ch);*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            String result = getResultString(str);
            System.out.println("result = " + result);
        }
    }

    private static String getResultString(String temp) throws Exception{
        char[] chars = temp.toCharArray();
        int[] arrays = new int[130];
        for (int i = 0; i < chars.length; i++) {
            arrays[chars[i]]++;
        }
        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i] > max){
                max = arrays[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (max > 0){
            for (int i = 0; i < arrays.length; i++) {
                if(max == arrays[i]){
                    sb.append((char)i);
                }
            }
            max--;
        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        char[] chars = "abcdd".toCharArray();
        int[] arrays = new int[200];
        System.out.println(arrays.length);
        for (int i = 0; i < chars.length; i++) {
            arrays[chars[i]]++;
        }
        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            if(max < arrays[i]){
                max = arrays[i];
            }
        }
        for (int i = 0; i < arrays.length; i++) {
            if(max == arrays[i]){
                for (int j = 0; j < max; j++) {
                    System.out.println((char)j);
                }
            }
        }
    }*/
}
