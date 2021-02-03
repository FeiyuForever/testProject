package com.feiyu.data.practise.leetcode.huawei.binary;

import org.junit.Test;
import java.util.*;

/**
 * Created by xzhou.James on 2021/1/24
 *
 * 将十六进制 转换为 十进制
 */
public class BinaryConvert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //0xAEF
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String newLine = line.substring(2);
            String str = new StringBuilder(newLine).reverse().toString();
            int count = 0;
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c){
                    case '0':
                        sum += (Math.pow(16,count)) * 0;
                        break;
                    case '1':
                        sum += (Math.pow(16,count)) * 1;
                        break;
                    case '2':
                        sum += (Math.pow(16,count)) * 2;
                        break;
                    case '3':
                        sum += (Math.pow(16,count)) * 3;
                        break;
                    case '4':
                        sum += (Math.pow(16,count)) * 4;
                        break;
                    case '5':
                        sum += (Math.pow(16,count)) * 5;
                        break;
                    case '6':
                        sum += (Math.pow(16,count)) * 6;
                        break;
                    case '7':
                        sum += (Math.pow(16,count)) * 7;
                        break;
                    case '8':
                        sum += (Math.pow(16,count)) * 8;
                        break;
                    case '9':
                        sum += (Math.pow(16,count)) * 9;
                        break;
                    case 'A':
                        sum += (Math.pow(16,count)) * 10;
                        break;
                    case 'B':
                        sum += (Math.pow(16,count)) * 11;
                        break;
                    case 'C':
                        sum += (Math.pow(16,count)) * 12;
                        break;
                    case 'D':
                        sum += (Math.pow(16,count)) * 13;
                        break;
                    case 'E':
                        sum += (Math.pow(16,count)) * 14;
                        break;
                    case 'F':
                        sum += (Math.pow(16,count)) * 15;
                        break;
                    default:
                        break;
                }
                count++;
            }
            System.out.println(sum);
        }
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
