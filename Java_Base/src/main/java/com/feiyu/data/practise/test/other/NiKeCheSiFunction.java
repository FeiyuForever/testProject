package com.feiyu.data.practise.test.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/7/22  21:59
 *
 * 任何一个正整数的立方 = 连续的三个奇数和
 */
public class NiKeCheSiFunction {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            if(str.length() > 0){
                int params = Integer.parseInt(str);
                if(params <= 0){
                    System.out.println("请输入大于等于0的整数");
                    continue;
                }
                String result = getResult(params);
                System.out.println(result);
            }
        }
    }

    private static String getResult(int params) {
        if(params == 1){
            return "1";
        }
        int[] arrays = new int[params];
        arrays[0] = params * (params - 1) + 1;
        for (int i = 1; i < arrays.length; i++) {
            arrays[i] = arrays[i-1] + 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrays[0]);
        for (int i = 1; i < arrays.length; i++) {
            stringBuilder.append("+");
            stringBuilder.append(arrays[i]);
        }
        return stringBuilder.toString();
    }
}
