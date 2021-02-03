package com.feiyu.data.practise.leetcode.huawei.sort;

import java.util.Arrays;

/**
 * Created by xzhou.James on 2020/12/27
 *
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
public class MergeSort {

    public static void main(String[] args) {
        int[] mergeArray = {12, 5, 8, 10, 25, 0, 3, 9};
        getMergeSorts(mergeArray);
        for (int elem : mergeArray) {
            System.out.print(elem + "\t");
        }
    }

    /**
     * 分治法  递归 解决
     *
     * @param mergeArray
     */
    private static void getMergeSorts(int[] mergeArray) {
        int start = 0;
        int arrayLength = mergeArray.length;
        int middle = arrayLength / 2;
        //最小化 每组两个元素 到不可在拆分
        while (arrayLength > 1) {
            //截取 数组的一半
            int[] leftArray = Arrays.copyOfRange(mergeArray, start, middle);
            int[] rightArray = Arrays.copyOfRange(mergeArray, middle, arrayLength);
            //递归划分 左右两侧
            getMergeSorts(leftArray);
            getMergeSorts(rightArray);
            //比较元素大小
            merge(mergeArray, leftArray, rightArray);
        }
    }

    private static void merge(int[] mergeArray, int[] leftArray, int[] rightArray) {
        int m = 0;
        int left = 0;
        int right = 0;
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] < rightArray[right]) {
                mergeArray[m] = leftArray[left];
                m++;
                left++;
            } else {
                mergeArray[m] = rightArray[right];
                m++;
                right++;
            }
        }
        //剩余的其他 元素比较
        while (right < rightArray.length) {
            mergeArray[m] = rightArray[right];
            m++;
            right++;
        }

        while (left < leftArray.length) {
            mergeArray[m] = leftArray[left];
            m++;
            left++;
        }
    }
}
