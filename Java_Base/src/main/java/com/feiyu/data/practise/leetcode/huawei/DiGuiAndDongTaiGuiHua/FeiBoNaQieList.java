package com.feiyu.data.practise.leetcode.huawei.DiGuiAndDongTaiGuiHua;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2020/12/29
 */
public class FeiBoNaQieList{

    //递归的方式
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        int result = getNum(line);
        System.out.println(result);
    }
    public static int getNum(int num){
        if(num == 1 || num == 2){
            return 1;
        }
        return getNum(num-1)+getNum(num-2);
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            int result = getNumTest(line);
            System.out.println(result);
        }
    }

    public static int getNumTest(int num){
        if(num < 3){
            return 1;
        }
        int a = 1,b = 1;
        int result = 0;
        for(int i = 2;i < num; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }*/
}
