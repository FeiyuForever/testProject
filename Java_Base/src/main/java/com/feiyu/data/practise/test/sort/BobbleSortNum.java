package com.feiyu.data.practise.test.sort;

/**
 * @Author xzhou.James
 * @Date 2020/7/14  22:48
 */
public class BobbleSortNum {

    public static void main(String[] args) {
        int[] temp = {3,5,1,8,0,4};
        int[] result = bobbleSort(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] bobbleSort(int[] temp) {
        int lengths = temp.length;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 1; i < lengths; i++) {
                if(temp[i-1] > temp[i]){
                    int array = temp[i-1];
                    temp[i-1] = temp[i];
                    temp[i] = array;
                    flag = true;
                }
            }
            lengths--;
        }
        return temp;
    }
}
