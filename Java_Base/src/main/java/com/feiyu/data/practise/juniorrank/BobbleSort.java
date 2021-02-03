package com.feiyu.data.practise.juniorrank;

/**
 * Created by xzhou.James on 2020/9/19
 *
 * 冒泡排序
 */
public class BobbleSort {
    public static void main(String[] args) {
        int[] array = {4,8,6,2,11,25,0,9};
        getResultArray(array);
        for (int a:array) {
            System.out.print(a + "\t");
        }
    }

    private static void getResultArray(int[] array) {
        int length = array.length-1;
        boolean flag = false;
        while (length > 0){
            for (int i = 1; i <= length; i++) {
                if(array[i-1] > array[i]){
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    flag = true;
                }
            }
            if(flag){
                length--;
            }
        }
    }
}
