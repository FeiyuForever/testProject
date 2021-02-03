package com.feiyu.data.practise.leetcode.huawei.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xzhou.James on 2021/1/24
 *
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class FillingStringToArray2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            while (line.length() > 8){
                System.out.println(line.substring(0,8));
                line = line.substring(8);
            }
            String newLine = line;
            for (int i = 0; i < 8 - line.length(); i++) {
                newLine = newLine.concat("0");
            }
            System.out.println(newLine);
        }
    }


    @Test
    public void TestString(){
        String a = "adsadasdasdsad";
        String b = a.substring(a.length()-1);
        System.out.println("b = " + b);
        while (a.length() >= 8){
            a.substring(0,8);
            a = a.substring(8);
        }
    }
}
