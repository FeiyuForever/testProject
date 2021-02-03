package com.feiyu.data.user.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/8/1  10:27
 */
public class JieCheng {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            int params = Integer.valueOf(str);
            int result = getResult(params);
            System.out.println("result = " + result);
        }
    }

    private static int getResult(int params) {
        if (params < 2) {
            return 1;
        }
        return getResult(params - 1) * params;
    }
}
