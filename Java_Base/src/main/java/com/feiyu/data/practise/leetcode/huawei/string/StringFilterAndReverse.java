package com.feiyu.data.practise.leetcode.huawei.string;


import java.util.*;
/**
 * Created by xzhou.James on 2021/1/29
 *
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 */
public class StringFilterAndReverse {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.substring(line.length()-1).equals("0")){
                System.exit(0);
            }
            Set<Character> set = new LinkedHashSet<>();
            char[] chars = line.toCharArray();
            for(int i = chars.length-1; i >= 0;i--){
                set.add(chars[i]);
            }
            StringBuilder sb = new StringBuilder();
            set.forEach(sb::append);
            int num = Integer.parseInt(sb.toString());
            System.out.println(num);
        }
    }
}
