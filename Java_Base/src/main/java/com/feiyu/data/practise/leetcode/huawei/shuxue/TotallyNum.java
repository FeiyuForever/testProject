package com.feiyu.data.practise.leetcode.huawei.shuxue;

import java.util.*;
import javax.script.*;

/**
 * Created by xzhou.James on 2021/1/1
 *
 * 计算完全数  6  28  496 33558826 。。。。
 *
 * 输入一个数，计算在这个数 之内的所有完全数 个数
 */
public class TotallyNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int enter = in.nextInt();
            int count = 0;
            for (int i = 1; i < enter; i++) {
                int sum = 0;
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
        in.close();
    }

}
