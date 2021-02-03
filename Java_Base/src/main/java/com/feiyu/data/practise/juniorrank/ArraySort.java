package com.feiyu.data.practise.juniorrank;

import java.util.Arrays;

/**
 * Created by xzhou.James on 2020/10/1
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] array = {5, 7, 2, 15, 56, 0, 9};
        int[] resultArray = getResult(array);
        for (int elem : resultArray) {
            System.out.println(elem + "\t");
        }
    }

    private static int[] getResult(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
