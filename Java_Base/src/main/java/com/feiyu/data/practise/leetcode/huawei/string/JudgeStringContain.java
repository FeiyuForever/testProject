package com.feiyu.data.practise.leetcode.huawei.string;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/3
 * <p>
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，
 * 然后输出输入字符串中该字母的出现次数。不区分大小写。
 */
public class JudgeStringContain {

    //replaceAll  （正则表达式 转换）
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine().toLowerCase();
            String s = in.nextLine().toLowerCase();
            System.out.println(str.length()-(str.replaceAll(s,"").length()));
        }
    }

    @Test
    public void  TestReplaceAll(){
        String a = "Asdaa 123";
        String b = "s";

        System.out.println("a.length()"+a.length());
        String c = a.replaceAll(b,"S");
        System.out.println("c = " + c);

        //给a每个字符 前 加一个 s
        String d = a.replaceAll("",b);
        System.out.println("d = " + d);

        //利用 replaceAll 把另一个字符串里的字符 代替为 "" (空字符串)
        String e = a.replaceAll(b,"");
        System.out.println("e = " + e);
    }

    //方法一 进行转换比较
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String s = in.nextLine();
            if ((str == null) || (s == null)) {
                System.out.println("-1");
                System.exit(0);
            }
            int count = 0;
            String a = str.toLowerCase();
            String b = s.toLowerCase();
            for (int i = 0; i < a.length(); i++) {
                if (b.charAt(0) == a.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }*/
}
