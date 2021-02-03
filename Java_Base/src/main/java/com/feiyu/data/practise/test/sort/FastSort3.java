package com.feiyu.data.practise.test.sort;

/**
 * Created by xzhou.James on 2020/9/5
 * <p>
 * 快速排序算法
 */
public class FastSort3 {

    public static void main(String[] args) {
        int[] array = {8, 6, 1, 9, 12, 59, 0, 23};
        getResultArray(array, 0, array.length - 1);
        for (int elem : array) {
            System.out.println(elem + "\t");
        }
    }

    private static void getResultArray(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int middle = array[start];
        while (left < right) {
            while (middle < array[right]) {
                right--;
            }
            if (middle > array[right]) {
                int temp = middle;
                middle = array[right];
                array[right] = temp;
            }
            while (middle > array[left]) {
                left++;
            }
            if (middle < array[left]) {
                int temp = middle;
                middle = array[left];
                array[left] = temp;
            }
        }

        getResultArray(array, start, left - 1);
        getResultArray(array, left + 1, end);
    }
}
