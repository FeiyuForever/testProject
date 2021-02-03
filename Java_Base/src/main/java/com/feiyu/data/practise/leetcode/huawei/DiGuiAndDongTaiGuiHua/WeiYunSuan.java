package com.feiyu.data.practise.leetcode.huawei.DiGuiAndDongTaiGuiHua;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/2
 *
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 */
public class WeiYunSuan {

    /*public static void main(String[] args) {
        System.out.println("10 & 12 ："+(10 & 12));
        System.out.println("4 | 2 ："+(4 | 2));
        System.out.println("4 ^ 2 ："+(4 ^ 2));
        System.out.println("~2 ："+(~2));
        System.out.println("1 << 2 ："+(1 << 2));
        System.out.println("-6 >> 2 ："+(-6 >> 2));

        //// -6 >>> 2 （无符号右移 高位补0）
        //// 1111 1111 1111 1111 1111 1111 1111 1010
        //// 0001 1111 1111 1111 1111 1111 1111 1111  ==  2^30 = (1073741822)
        System.out.println("-6 >>> 2 ："+(-6 >>> 2));

        System.out.println("6 >> 2 ："+(6 >> 2));
        System.out.println("6 >>> 2 ："+(6 >>> 2));

        System.out.println("5 >> 2 ："+(5 >> 2));
        System.out.println("5 >>> 2 ："+(5 >>> 2));
    }*/

    /**
     * 方法 1
     *
     * 移位 解决问题
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            int num = getResult(line);
            System.out.println("num = " + num);
        }
    }
    public static int getResult(int num){
        int count = 0;
        while(num != 0){
            // & 运算 为 1 ，代表该位存在
            if((num & 1) == 1){
                count++;
            }
            //无符号 右移1位，取下一个高位
            num = num >>> 1;
        }
        return count;
    }


    /**
     * 方法 2
     *
     *  & 相同为（1） 解决问题
     */
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            int num = getResult(line);
            System.out.println(num);
        }
    }
    public static int getResult(int num){
        int count = 0;
        while(num != 0){
            num = num & num - 1;
            System.out.println("num:"+num);
            count++;
        }
        return count;
    }*/
}
