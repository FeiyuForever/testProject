package com.feiyu.data.user.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @Author xzhou.James
 * @Date 2020/7/25  10:43
 */
public class FindNumnerGentle {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            int param = Integer.valueOf(str.toString());
            String[] strings = bufferedReader.readLine().split(" ");
            int num = Integer.valueOf(bufferedReader.readLine());
            int result = getResult(param, strings, num);
            System.out.println(result);
        }
    }

    private static int getResult(int param, String[] strings, int num) {
        int[] newArray = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            newArray[i] = Integer.valueOf(strings[i]);
        }
        //对数组进行去重
        //int[] newArray = getNewArray(arrays);
        int length = newArray.length;
        boolean flag = false;
        while (length > 0) {
            flag = true;//2 3 1 | 2 1 3 | 1 2 3
            for (int i = 1; i < newArray.length; i++) {
                if (newArray[i - 1] > newArray[i]) {
                    int temp = newArray[i - 1];
                    newArray[i - 1] = newArray[i];
                    newArray[i] = temp;
                    flag = false;
                }
            }
            length--;
        }
        //选取最大值和最小值
        int result = getLastNum(newArray, num);
        return result;
    }

    private static int[] getNewArray(int[] arrays) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < arrays.length; i++) {
            hashSet.add(arrays[i]);
        }
        Integer[] newArrays = hashSet.toArray(new Integer[]{});
        int[] arrs = new int[newArrays.length];
        for (int i = 0; i < newArrays.length; i++) {
            arrs[i] = newArrays[i];
        }
        return arrs;
    }

    private static int getLastNum(int[] arrays, int num) {
        int count = 0;
        int[] minArray = new int[num];
        int[] maxArray = new int[num];
        for (int i = 0; i < arrays.length; i++) {
            if (num > i) {
                minArray[i] = arrays[i];
            }
            if (i >= arrays.length - num) {
                maxArray[i - (arrays.length - num)] = arrays[i];
            }
        }
        label:
        for (int i = 0; i < maxArray.length; i++) {
            for (int j = 0; j < minArray.length; j++) {
                if (minArray[j] == maxArray[i]) {
                    count = -1;
                    break label;
                }
            }
        }
        if (count == -1) {
            return count;
        } else {
            for (int i = 0; i < minArray.length; i++) {
                count += minArray[i];
            }
            for (int i = 0; i < maxArray.length; i++) {
                count += maxArray[i];
            }
        }
        return count;
    }
}
