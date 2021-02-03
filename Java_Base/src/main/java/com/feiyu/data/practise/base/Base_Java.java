package com.feiyu.data.practise.base;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @Author xzhou.James
 * @Date 2020/5/20  10:49
 */
public class Base_Java {

    public static void main(String args[]) {
        int i = -5;
        i =  ++i; // -4
//        i =  i++; // -5
        System.out.println(i);
        System.gc();

        try{}catch (Exception e){}finally {

        }
    }
}
