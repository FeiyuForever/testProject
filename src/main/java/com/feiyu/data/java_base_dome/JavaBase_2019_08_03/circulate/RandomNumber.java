package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.circulate;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author xzhou.James
 * @Date 2019/8/4  13:56
 *
 * 创建随机数
 */
public class RandomNumber {

    public static void main(String[] args) throws Exception {

        int  number  = new Random().nextInt(10);
        if(number == 9){
            System.out.println("随机数是左毕右毕的");
        }
        if(number == 8){
            System.out.println("随机数是左毕右开的");
        }
    }

    /**
     * 求  数组里的最大值
     */
    @Test
    public void TestMaxNumber(){

        int[] number = {5,88,9,12,1,0};
        int maxNumber = number[0];
        for(int x= 0;x<number.length;x++){
            if(maxNumber < number[x]){
                maxNumber = number[x];// maxNumber取到一个值  会赋值   和其他的数进行比较大小
            }else{
                System.out.println("判断失误！");
            }
        }
        System.out.println("最大值 ---- "+maxNumber);
    }

    /**
     * 求  数组里的最小值
     */
    @Test
    public void TestMinNumber(){

        int[] number = {5,88,0,12,1,8};
        int minNumber = number[0];
        for(int x= 0;x<number.length;x++){
            if(minNumber > number[x]){
                minNumber = number[x];// maxNumber取到一个值  会赋值   和其他的数进行比较大小
            }else{
                System.out.println("判断失误！");
            }
        }
        System.out.println("最小值 ---- "+minNumber);
    }

    /**
     * 快速求  数组里的最小值
     */
    @Test
    public void TestCollectionsNumber(){

        int[] number = {5,88,0,12,1,8};

        //工具类转型
        //int[] arrays= ArrayUtils.ensureCapacity(number,0);
        List<Integer> list = new ArrayList<>();
        for(int num:number){
            list.add(num);
        }
        int max = Collections.max(list);
        System.out.println("max---"+max);
    }
}
