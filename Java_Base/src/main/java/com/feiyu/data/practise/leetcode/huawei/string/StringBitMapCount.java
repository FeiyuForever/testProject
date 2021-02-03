package com.feiyu.data.practise.leetcode.huawei.string;

import org.junit.Test;

import java.util.Scanner;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xzhou.James on 2021/1/29
 *
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，
 * 不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 */
public class StringBitMapCount {
    /**
     * 位图统计
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            BitSet bitSet = new BitSet(128);
            for (int i = 0; i < line.length(); i++) {
                if(!bitSet.get(line.charAt(i))){
                    bitSet.set(line.charAt(i));
                }
            }
            System.out.println(bitSet.cardinality());
        }
    }

    @Test
    public void TestString(){
        String a = "I am a" +
                " good " +
                " boy";
        //  \\s表示 空格,回车,换行等空白符,
        //  +号表示一个或多个的意思,所以...
        String[] strs = a.split("\\s+");
        Deque<String> queue = new LinkedList<>();
        //双头链表 （Deque）- 给每次的头部插入元素
        Arrays.stream(strs).forEach(queue::addFirst);
        //1.8 字符串的 join的方法
        System.out.println(String.join(" ",queue));
        //去掉前后的空格
        /*String b = a.trim();
        System.out.println("b = " + b);
        String c = String.join(",",b);
        System.out.println("c = " + c);*/
    }
}
