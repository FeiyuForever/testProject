package com.feiyu.data.java_base_dome.JavaBase_2019_08_18;


/**
 * @Author xzhou.James
 * @Date 2019/8/18  21:06
 *
 * 测试 equals   and    ==
 */
public class EqualsDome101 {

    public static void main(String[] args) {

        Value  v1 = new Value();

        Value  v2 = new Value();

        v1.number = v2.number = 47;

        System.out.println(v1.equals(v2));

        System.out.println(v1==v2);
    }

}

