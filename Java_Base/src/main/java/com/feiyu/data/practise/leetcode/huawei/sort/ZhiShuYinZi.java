package com.feiyu.data.practise.leetcode.huawei.sort;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/24
 */
public class ZhiShuYinZi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long next = scanner.nextLong();
            getPrimeNum(Math.sqrt(next));
        }
    }

    private static void getPrimeNum(double next) {
        for (int i = 2; i <= next; i++) {
            if(next % i == 0){
                System.out.print(i + " ");
                getPrimeNum(next/i);
                break;
            }
            if(next == i){
                System.out.print(i + " ");
            }
        }
    }

    /*private static void getPrimeNum(long next) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= next; i++) {
            while (next % i == 0){
                stringBuilder.append(i).append(" ");
                next /= i;
            }
        }
        System.out.println(stringBuilder.toString());
    }*/
}
