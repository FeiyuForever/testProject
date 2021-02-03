package com.feiyu.data.practise.leetcode.huawei.DiGuiAndDongTaiGuiHua;

import java.util.*;
import javax.script.*;

/**
 * Created by xzhou.James on 2021/1/1
 *
 * 题目描述
 *
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * （用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 *
 * 递归 + 动态规划
 */
public class PutApple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int count = getResult(m, n);
            System.out.println(count);
        }
        in.close();
    }

    public static int getResult(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        //苹果小于盘子的数量
        if (m < n) {
            return getResult(m, m);
        } else {
            //苹果大于盘子的数量
            if (m == n) {
                return getResult(m, n - 1) + 1;
            } else {
                //苹果大于盘子数量  ---> 至少有一个盘子为空  || 每个盘子至少放一个苹果
                return getResult(m, n - 1) + getResult(m - n, n);
            }
        }
        //(7 2) + (4,3)
        //(7 1) + (1,3)
        //(7 0) + (1,1)
    }
}
