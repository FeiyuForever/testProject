package com.feiyu.data.practise.leetcode.huawei.shuxue;

import java.util.Scanner;

/**
 * @author Administrator
 * @date 2021/1/3 15:21
 * @description
 */
public class GpuGetTime {
    private static Integer n1 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            n1 = a;
            String arr = scanner.nextLine();
            String[] strArray = arr.split(" ");
            if (b != strArray.length) {
                System.out.println(0);
            }
            int num = getResult(a, b, strArray);
            System.out.println(num);
        }
    }

    private static int getResult(int v, int length, String[] strArray) {
        int count = 0;
        int flag = 0;
        for (int i = 0; i < length; i++) {
            int elem = Integer.valueOf(strArray[i]);
            if (elem <= v) {
                count++;
            }
            if (elem > v) {
                int m = elem % v;
                if (m == 0) {
                    count += elem / v;
                } else {
                    flag += elem;
                }
            }
        }
        int resultNum = 0;
        if (flag % v == 0) {
            count += flag / v;
        } else {
            //递归计算 大于的情况
            //resultNum = flag / v;
            //resultNum++;
            resultNum = getResultNum(flag);
        }
        return count + resultNum;
    }

    /**
     * 递归计算值
     *
     * @param flag
     * @return
     */
    private static int getResultNum(int flag) {
        if (flag == n1) {
            return 1;
        }
        int a = flag / n1;
        int b = flag % n1;
        int c = a + b;
        return a+getResultNum(c);
    }
}
