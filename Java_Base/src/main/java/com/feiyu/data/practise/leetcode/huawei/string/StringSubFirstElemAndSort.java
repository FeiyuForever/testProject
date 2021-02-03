package com.feiyu.data.practise.leetcode.huawei.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xzhou.James on 2021/1/30
 * <p>
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class StringSubFirstElemAndSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = Integer.parseInt(in.nextLine());
            String[] array = new String[num];
            for (int i = 0; i < num; i++) {
                String next = in.nextLine();
                array[i] = next;
            }
            Arrays.stream(array).sorted().forEach(System.out::println);
        }
    }
}
