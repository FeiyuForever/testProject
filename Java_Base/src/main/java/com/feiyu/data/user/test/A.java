package com.feiyu.data.user.test;

import java.util.HashSet;

/**
 * @Author xzhou.James
 * @Date 2020/7/23  22:48
 */
public class A {

    public static void main(String[] args) {
        /*HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("1");
        hashSet.add("1");
        for (String s:hashSet) {
            System.out.println(s);
        }*/

        /*String a=  "12";
        String b=  "23";
        if(b.contains(a)){
            System.out.println(666);
        }else{
            System.out.println(999);
        }*/

        int[] arrays = new int[]{1,2,3,4,5};
        for (int i = arrays.length-1; i >= 0; i--) {
            //System.out.print(i);
            System.out.print(arrays[i]);
        }
    }
}
