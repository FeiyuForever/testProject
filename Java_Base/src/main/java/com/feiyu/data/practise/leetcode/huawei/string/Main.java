package com.feiyu.data.practise.leetcode.huawei.string;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2020/12/29
 *
 * 三个  汽水瓶 换一瓶 水  问题
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            int result = getNum(line);
            System.out.println(result);
        }
    }
    public static int getNum(int n){
        if(n == 1 || n == 0){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        else{
            int a = n / 3;
            int b = n % 3;
            int num = a+b;
            return a+getNum(num);
        }
    }

    @Test
    public void TestString(){
        String a = "fdfdfsdfsdff";
        String b = a.substring(0,8);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        String c = a.replaceFirst(b,"");
        System.out.println("c = " + c);
    }
}

