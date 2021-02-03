package com.feiyu.data.practise.leetcode.huawei.sort;

import java.util.Scanner;

/**
 * Created by xzhou.James on 2021/1/24
 */
public class ZhiShuYinZi2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            for (long i = 2; i <= (long)Math.sqrt(num); i++) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
            }
            System.out.println(num == 1 ? "" : num+" ");
        }
    }
}
