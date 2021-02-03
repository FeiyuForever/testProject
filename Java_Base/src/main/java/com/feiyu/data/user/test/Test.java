package com.feiyu.data.user.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author xzhou.James
 * @Date 2020/7/23  21:43
 */
public class Test {
    /*public static void main(String[] args) {
        int[] array = new int[]{5,4,1,3,2};
        int[] a = getSortArray(array);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static int[] getSortArray(int[] arrays) {
        int length = arrays.length;
        boolean flag = false;
        while (length > 0){
            flag = true;
            for (int i = 1; i < arrays.length; i++) {
                if(arrays[i-1] > arrays[i]){
                    int temp = arrays[i-1];
                    arrays[i-1] = arrays[i];
                    arrays[i-1] = temp;
                    flag = false;
                }
            }
            length--;
        }
        return arrays;
    }*/

    public static void main(String[] args) {
        String[] strings = {"3","2","3","4","2"};
        int result = getResult(5, strings, 2);
        if (result == -1) {
            System.out.println("输入非法数字，或最大最小值有重叠！");
        }
        System.out.println("result = " + result);
    }

    private static int getResult(int params, String[] strings, int numbers) {
        if (params != strings.length) {
            return -1;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            //arrays[i] = (Integer.valueOf(strings[i]));
            hashSet.add(strings[i]);
        }
        Object[] objects = hashSet.toArray();
        int[] arrays = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            arrays[i] = (Integer.valueOf(objects[i].toString()));
        }
        //数组进行排序
        int[] newArrays = getSortArray(arrays);
        int result = getResultNumber(newArrays, numbers);
        return result;
    }

    private static int getResultNumber(int[] newArrays, int numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newArrays.length; i++) {
            stringBuilder.append(newArrays[i]);
        }
        String allWord = stringBuilder.toString();
        String first = allWord.substring(0, numbers);
        StringBuilder stringBuilder1 = new StringBuilder(allWord);
        String second = stringBuilder1.reverse().toString().substring(0, numbers);
        char[] chars = first.toCharArray();
        char[] chars1 = second.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num1 = chars[i] - '0';
            for (int j = 0; j < chars1.length; j++) {
                int num2 = chars1[j] - '0';
                if(num1 == num2){
                    return -1;
                }
            }
        }
        if (first.length() == 1 && second.length() == 1) {
            return Integer.parseInt(first) + Integer.parseInt(second);
        }
        int min = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            min += num;
        }
        int max = 0;
        for (int i = 0; i < chars1.length; i++) {
            int num = chars1[i] - '0';
            max += num;
        }
        return min + max;
    }

    private static int[] getSortArray(int[] arrays) {
        int length = arrays.length;
        boolean flag = false;
        while (length > 0) {
            flag = true;
            for (int i = 1; i < arrays.length; i++) {
                if (arrays[i - 1] > arrays[i]) {
                    int temp = arrays[i - 1];
                    arrays[i - 1] = arrays[i];
                    arrays[i] = temp;
                    flag = false;
                }
            }
            length--;
        }
        return arrays;
    }
}
