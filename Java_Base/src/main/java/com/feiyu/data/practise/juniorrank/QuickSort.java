package com.feiyu.data.practise.juniorrank;

/**
 * Created by xzhou.James on 2020/9/19
 *
 * 快速排序算法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,8,6,2,11,25,0,9};
        getResultArray(array,0,array.length-1);
        for (int elem:array) {
            System.out.print(elem+"\t");
        }
    }

    private static void getResultArray(int[] array, int start, int end) {
        if(start > end){
            return;
        }
        int left = start;
        int right = end;
        int middle = array[left];
        while (left < right){
            if(array[right] > middle){
                right--;
            }
            if(array[right] < middle){
                int temp = array[right];
                array[right] = middle;
                middle = temp;
            }
            if(array[left] < middle){
                left++;
            }
            if(array[left] > middle){
                int temp = array[left];
                array[left] = middle;
                middle = temp;
            }
        }
        getResultArray(array,start,left-1);
        getResultArray(array,left+1,end);
    }
}
