package com.feiyu.data.practise.test.sort;

import java.util.Arrays;

/**
 * @Author xzhou.James
 * @Date 2020/8/22  9:04
 */
public class FastSort2 {
    public static void main(String[] args) {
        int[] array = {2,5,6,1,12,9,4,56};
        //int[] array = {24,5,6,1,12,9,4,8};
        //Arrays.sort(array);
        getResult(array,0,array.length-1);
        for (int elem:array) {
            System.out.print(elem+"\t");
        }
    }

    private static void getResult(int[] array, int start, int end) {
        if(start > end){
            return;
        }
        int left = start;
        int right = end;
        int middle = array[left];
        while (left < right){
            while (middle < array[right]){
                right--;
            }
            if(middle > array[right]){
                int temp = array[right];
                array[right] = middle;
                middle = temp;
            }
            while (middle > array[left]){
                left++;
            }
            if(middle < array[left]){
                int temp = array[left];
                array[left] = middle;
                middle = temp;
            }
        }
        getResult(array,start,left-1);
        getResult(array,left+1,end);
    }
}
