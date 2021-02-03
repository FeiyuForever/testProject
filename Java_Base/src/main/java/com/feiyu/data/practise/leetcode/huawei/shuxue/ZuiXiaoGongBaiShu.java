package com.feiyu.data.practise.leetcode.huawei.shuxue;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/2
 */
public class ZuiXiaoGongBaiShu {

    private static int temp = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (n > m) {
                int temp = n;
                n = m;
                m = temp;
            }
            temp = m;
            int num = getNum(m, n);
            System.out.println(num);
        }
        in.close();

        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private static int getNum(int m, int n) {
        if (m == n) {
            return m;
        }
        if (m % n == 0) {
            return m;
        }
        return getNum(m + (temp), n);
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            int temp = m * n;
            int num = temp / getNum(m,n);
            System.out.println(num);
        }
        in.close();
    }
    //辗转相除法
    private static int getNum(int m,int n){
        if(n == 0){
            return m;
        }
        return getNum(n,m%n);
    }*/
}
