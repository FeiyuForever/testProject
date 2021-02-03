package com.feiyu.data.java_base_dome.JavaBase_2019_08_18;

import java.util.Random;

/**
 * @Author xzhou.James
 * @Date 2019/8/18  20:49
 *
 * Java  产生随机数
 */
public class Java_Random {

    public static void main(String[] args) {


        /**
         * 产生随机数
         */

        Random random = new Random();

        int number = random.nextInt(2)+1;

        System.out.println(number);
    }
}
