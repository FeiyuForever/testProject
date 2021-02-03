package com.feiyu.data.practise.leetcode.huawei.DiGuiAndDongTaiGuiHua;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/2
 *
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 *
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 *
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 */
public class DengChaShuLie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            if(line == 0){
                System.out.println(line);
            }
            int num = getNums(line);
            int count = 0;
            if(line % 2 == 0){
                count = (2+num) * (line/2);
            }else{
                count = (2+num) * (line / 2) + ((2+num)/2);
            }
            System.out.println(count);
        }
    }
    private static int getNums(int n){
        if(n == 1){
            return 2;
        }
        return 3+getNums(n - 1);
    }

    /**
     * 导数学 公式
     */
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            if(line == 0){
                System.out.println(line);
            }
            int num = line*(3*line+1) / 2;
            System.out.println(num);
        }
    }*/
}
