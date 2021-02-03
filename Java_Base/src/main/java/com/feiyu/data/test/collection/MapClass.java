package com.feiyu.data.test.collection;

import java.util.*;

/**
 * Created by xzhou.James on 2020/12/12
 *
 * map 集合的测试
 */
public class MapClass {

    public static void main(String[] args) {
       Map<String,Object> map = new HashMap<>();
        map.put(null,"null1");
        map.put(null,"null2");
        map.put(null,"null3");
        map.put("hhh","aa");
        map.forEach((key,value) ->{
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });
    }
}
