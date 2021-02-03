package com.feiyu.data.practise.leetcode.huawei.sort;

import java.util.Arrays;

/**
 * Created by xzhou.James on 2020/12/27
 * <p>
 * 归并排序(稳定排序)
 * <p>
 * [1,3,9,2,8,12,36,5]
 * <p>
 * [1,3,9,2] [8,12,36,5]
 * [1,3] [9,2] [8,12] [36,5]
 * <p>
 * [1,3] [2,9] [8,12] [5,36]
 * [1,2,3,9] [5,8,12,36]
 * <p>
 * [1,2,3,5,8,9,12,36]
 */
public class GuiBingSort {

    public static void main(String[] args) {
        int[] sumArray = {48, 8, 2, 10, 1, 19, 12,7};
        getMergeSort(sumArray);
        for (int elem : sumArray) {
            System.out.print(elem + "\t");
        }
    }

    /**
     * sumArray
     *
     * @param sumArray
     */
    private static void getMergeSort(int[] sumArray) {
        int start = 0;
        int length = sumArray.length;
        int middle = length / 2;
        //第一步 拆分数组
        if (length > 1) {
            int[] leftArray = Arrays.copyOfRange(sumArray, start, middle);//截取数组的左半部分
            int[] rightArray = Arrays.copyOfRange(sumArray, middle, length);//截取数组的右半部分
            getMergeSort(leftArray);//递归左半部分
            getMergeSort(rightArray);//递归右半部分
            mergeArray(sumArray, leftArray, rightArray);
        }
    }

    /**
     * 两两 个 数组比较元素大小 填充到新的数组
     *
     * @param sumArray
     * @param leftArray
     * @param rightArray
     */
    private static void mergeArray(int[] sumArray, int[] leftArray, int[] rightArray) {
        int m = 0; //sumArray
        int left = 0;//leftArray
        int right = 0;//rightArray
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] < rightArray[right]) {
                sumArray[m] = leftArray[left];
                m++;
                left++;
            } else {
                sumArray[m] = rightArray[right];
                m++;
                right++;
            }
        }
        //如果右边有剩余的  则合并右边的
        while (right < rightArray.length){
            sumArray[m] = rightArray[right];
            m++;
            right++;
        }
        //如果左边有剩余的  则合并左边的
        while (left < leftArray.length){
            sumArray[m] = leftArray[left];
            m++;
            left++;
        }
    }
}
