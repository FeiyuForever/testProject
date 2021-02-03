package com.feiyu.data.practise.leetcode.huawei.shuxue;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/27
 */
public class GetNumApproximate {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            float num = scanner.nextFloat();
            String str = String.valueOf(num);
            String[] strs = str.split("\\.");
            String secondElement = strs[1];
            double elem = secondElement.indexOf(0);
            int result = 0;
            if(elem >= 5){
                result = Integer.valueOf(strs[0]) + 1;
            }else{
                if(Integer.valueOf(strs[0]) <= 0){
                    result = 0;
                }else{
                    result = Integer.valueOf(strs[0]) - 1;
                }
            }
            System.out.println(result);
        }
    }

    @Test
    public void TestNum(){
        double num = 2.3;
        String str = String.valueOf(num);
        String[] strs = str.split("\\.");
        String secondElement = strs[1];
        double elem = Double.valueOf(secondElement.substring(0,1));
        int result = 0;
        if(elem >= 5){
            result = Integer.valueOf(strs[0]) + 1;
        }else{
            result = Integer.valueOf(strs[0]) <= 0 ? 0 : Integer.valueOf(strs[0]);
        }
        System.out.println("result: "+result);
    }

    @Test
    public void TestNumString(){
        String a = String.valueOf(25.3564);
        int chars = a.charAt(0);
        System.out.println("chars = " + chars);
        int num = a.indexOf(2);
        System.out.println("indexOf = " + num);
        int num1 = a.lastIndexOf(4);
        System.out.println("lastIndexOf = " + num1);
        String result = a.intern();
        System.out.println("result = " + result);

    }
}
