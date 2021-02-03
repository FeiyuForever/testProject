package com.feiyu.data.user.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/7/26  20:12
 * <p>
 * [1 1 2 3 5 8 13....]
 */
public class MainFunction {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            int params = Integer.valueOf(str);
            int result = getResult(params);
            System.out.println("result = " + result);
        }
    }

    //[1 1 2 3 5 8 13....]
    //     0 1 2 3 4
    private static int getResult(int params) {
        int first = 1;
        int second = 1;
        int count = 0;
        for (int i = 2; i < params; i++) {
            count = first + second;
            first = second;
            second = count;
        }
        return count;
    }

    /*private static int getResult(int params) {
        int first = 1;
        int second = 1;
        int count = 0;
        while (count < params) {
            count = first + second;
            first = second;
            second = count;
        }
        return count;
    }*/

    /*private static int getResult(int params) {
        if (params == 0 || params == 1) {
            return 1;
        }
        return getResult(params - 1) + getResult(params - 2);
    }*/
}
