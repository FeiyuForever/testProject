package com.feiyu.data.practise.middenrank;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/3
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int num = getCount(count);
            System.out.println(num);
        }
    }

    public static int getCount(int n){
        if(n <= 3){
            return 2;
        }
        int first = 1,second = 1,third = 2;
        for (int i = 4; i <= n; i++) {
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }
}
