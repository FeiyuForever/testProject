package com.feiyu.data.practise.leetcode.huawei.binary;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/30
 *
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 *  eg:  输入：5    ->   输出：2
 */
public class BinaryConvert3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = Integer.parseInt(scanner.nextLine());
            int d = Integer.bitCount(num);
            System.out.println(d);
        }
    }

    @Test
    public void Test(){
        //将十六进制 转换为 10进制
        String a = "AE";
        int b = Integer.valueOf(a,16);
        System.out.println("b = " + b);

        //计算10进制的二进制位数
        int c = 15;
        int d = Integer.bitCount(c);
        System.out.println("d = " + d);

        //将10进制转换为十六进制
        String OX = Integer.toHexString(174);
        System.out.println("OX = " + OX);

        //对 二进制 位数进行翻转
        int e = Integer.reverse(10241024);
        System.out.println("e = " + e);

        int f = 5 >> 1;
        System.out.println("f = " + f);

        int f0 = 5 >>> 1;
        System.out.println("f0 = " + f0);

        int f1 = -5 >> 1;
        System.out.println("f1 = " + f1);

        int f2 = -5 >>> 1;
        System.out.println("f2 = " + f2);
    }
}





















