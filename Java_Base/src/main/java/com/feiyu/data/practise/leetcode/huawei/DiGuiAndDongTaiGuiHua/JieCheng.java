package com.feiyu.data.practise.leetcode.huawei.DiGuiAndDongTaiGuiHua;


import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/1
 * <p>
 * n的阶乘  n!
 */
public class JieCheng {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            int num = getNum(n);
            System.out.println("num = " + num);
        }
    }

    private static int getNum(long n) {
        if (n == 1) {
            return 1;
        } else {
            return (int) (n * getNum(n - 1));
        }
    }

    @Test
    public void TestNumSum() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            int num = getNumSum(n);
            System.out.println("num = " + num);
        }
    }

    private int getNumSum(long n) {
        if (n == 1) {
            return 1;
        }
        return (int) n + getNumSum(n - 1);
    }
}
