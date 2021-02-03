package com.feiyu.data.practise.test.sort;

import java.util.Arrays;

/**
 * @Author xzhou.James
 * @Date 2020/8/12  22:23
 *
 * 快速排序算法
 */
public class FastSort {
    public static void main(String[] args) {
        int[] array = {3,5,1,9,6,0,8,12};
        getSortArray(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+" ");
        }
    }

    private static void getSortArray(int[] array,int start,int end) {
        //左边的变量
        int left = start;
        //右边的变量
        int right = end;
        //标识变量
        int temp = array[left];
        while (left < right){
            //用标识符和右边的值 进行比较
            while (temp < array[right]){
                right--;
            }
            //用标识符和左边的值 进行比较
            while (temp > array[left]){
                left++;
            }
            if(left < right){
                int tt = array[left];
                array[left] = array[right];
                array[right] = tt;
            }
        }
        array[start] = array[left];
        array[left] = temp;
        System.out.println(Arrays.toString(array));
        getSortArray(array,start,left);
        getSortArray(array,left+1,right);
    }
}
