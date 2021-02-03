package com.feiyu.data.practise.leetcode.huawei.shuxue;

import java.util.Scanner;

import static com.feiyu.data.practise.leetcode.huawei.string.Main.getNum;

/**
 * Created by xzhou.James on 2021/1/3
 */
public class TiaoTaiJie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int num = getNuma(n);
            System.out.println("num = " + num);
        }
    }

    private static int getNuma(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return 2 * getNuma(n-1);
    }
}
