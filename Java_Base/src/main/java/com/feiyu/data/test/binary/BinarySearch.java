package com.feiyu.data.test.binary;

/**
 * Created by xzhou.James on 2020/12/6
 *
 * 二分搜索技术
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,56,98,125,189,635,8954};
        int num = 8954;
        int result = getResult(array,num);
        System.out.println(result);
    }

    private static int getResult(int[] array,int num) {
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int middle = (start+end)/2;
            if(array[middle] == num){
                return array[middle];
            }
            if(num > array[middle]){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
}
