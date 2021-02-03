package com.feiyu.data.practise.test.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/7/22  22:16
 *
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 */
public class CommonStringLength {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            if(str.length() <= 0){
                System.out.println("请输入合法的字符串");
                continue;
            }
            String second = bufferedReader.readLine();
            if(second.length() > 0){
                int result = getResult(str,second);
                System.out.println(result);
            }
        }
    }

    private static int getResult(String first, String second) {
        if(first.length() > second.length()){
            if(first.contains(second)){
                return second.length();
            }
        }
        if(first.length() < second.length()){
            if(second.contains(first)){
                return first.length();
            }
        }
        return 0;
    }
}
