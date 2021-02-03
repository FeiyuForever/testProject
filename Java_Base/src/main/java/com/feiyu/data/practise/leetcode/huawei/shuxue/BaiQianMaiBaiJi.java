package com.feiyu.data.practise.leetcode.huawei.shuxue;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/2
 */
public class BaiQianMaiBaiJi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int line = in.nextInt();
            //7a+4b==100
            for(int i = 0;i <= 14; i++){
                for(int j = 0;j <= 25;j++){
                    if(7*i + 4*j == 100){
                        int m = 100 - i - j;
                        System.out.println(i+" "+j+" "+m);
                    }
                }
            }
        }
    }
}
