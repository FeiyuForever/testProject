package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.circulate;

import org.junit.jupiter.api.Test;

/**
 * @Author xzhou.James
 * @Date 2019/8/4  19:37
 *
 * 循环二维数组
 */
public class TwoArrays {

    @Test
    public void TestTwoArrays(){
        int[][] arrays = {{1,2,3},{4,5,6},{7,8,9}};
        for(int x = 0;x<arrays.length;x++){
            for(int y = 0;y<arrays[x].length;y++){
                System.out.print(arrays[x][y]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void TestTwoLeaveMethods(){

        int[] nums = {1,2,3,4,6,7,8,9};

        int target = 5;

        //二分法
        int result = returnMethods(nums,target);

        System.out.println("返回目标的索引值---->"+result);

    }


    private int returnMethods(int[] nums, int target) {

        int left = 0,right = nums.length-1;

        for(int x = 0; x < nums.length;x++){

            int mid = (left + right)/2; //整除忽略余数

            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left; //顺序插入   选择  left
    }
}
