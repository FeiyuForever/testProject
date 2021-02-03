package com.feiyu.data.practise.leetcode.huawei.sort;

import java.util.Arrays;

/**
 * Created by xzhou.James on 2020/12/27
 */
public class FastSort {

    public static void main(String[] args) {
        int[] array = {23, 3, 5, 9, 45, 34, 12, 0, 67,4,1};
        getFastSort(array, 0, array.length - 1);
        Arrays.stream(array);
        for (int elem : array) {
            System.out.print("elem = " + elem + "\t");
        }
    }

    private static void getFastSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int middle = array[left];
        while (left < right) {
            if (middle < array[right]) {
                right--;
            }
            if (array[right] < middle) {
                int temp = array[right];
                array[right] = middle;
                middle = temp;
            }
            if (array[left] < middle) {
                left++;
            }
            if (array[left] > middle) {
                int temp = array[left];
                array[left] = middle;
                middle = temp;
            }
        }
        getFastSort(array, start, left - 1);
        getFastSort(array, left + 1, end);
    }
}
