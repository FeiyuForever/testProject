package com.feiyu.data.practise.test.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/7/20  21:58
 *
 * 2 5 8 11 14 17 20
 */
public class ArithmeticSequence2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine())!=null){
            int result = Integer.parseInt(str);
            int number = getResult(result);
            System.out.println(number);
        }
    }

    private static int getResult(int n) {
        return (3*n*n+n) / 2;
    }
}
