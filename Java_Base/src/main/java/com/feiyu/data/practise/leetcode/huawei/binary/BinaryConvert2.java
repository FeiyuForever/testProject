package com.feiyu.data.practise.leetcode.huawei.binary;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by xzhou.James on 2021/1/24
 *
 * 将十六进制 转换为 十进制
 */
public class BinaryConvert2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //0xAEF
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(Integer.valueOf(line.substring(2),16));
            System.out.println(Integer.parseInt(line.replaceAll("x",""),16));
        }
    }

    @Test
    public void mainTest() {
        String line = "0xAF".replaceAll("x","");
        System.out.println(Integer.parseInt(line.replaceAll("0x",""),16));
    }

    @Test
    public void TestSum(){
        double a = Math.pow(16,2);
        System.out.println("a = " + a);

        System.out.println("=====");

        int b = Math.abs(-8);
        System.out.println("b = " + b);

        System.out.println("==开平方===");

        double c = Math.sqrt(8.0);
        System.out.println("c = " + c);

        System.out.println("==开立方根===");

        double c1 = Math.cbrt(8.0);
        System.out.println("c1 = " + c1);

        System.out.println("=====");

        double d = Math.max(8,9);
        System.out.println("d = " + d);

        System.out.println("=====");

        double e = Math.min(8,9);
        System.out.println("e = " + e);

        System.out.println("==Math.floor===");

        double f = Math.floor(8.56);
        System.out.println("f = " + f);

        System.out.println("==Math.ceil===");

        double g = Math.ceil(8.56);
        System.out.println("g = " + g);

        System.out.println("==Math.round===");

        double h = Math.round(8.56);
        System.out.println("h = " + h);

        System.out.println("==Math.rint===");

        double i = Math.rint(8.5);
        System.out.println("rint = " + i);
    }
}
