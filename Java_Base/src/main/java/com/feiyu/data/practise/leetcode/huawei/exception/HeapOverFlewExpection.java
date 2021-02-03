package com.feiyu.data.practise.leetcode.huawei.exception;

import java.util.*;

/**
 * Created by xzhou.James on 2020/12/27
 *
 * OutOfMemoryError: Java heap space
 *
 *
 */
public class HeapOverFlewExpection {

    public static void main(String[] args) {
        List<HeapOverFlewExpection> list = new ArrayList<>();
        while (true){
            list.add(new HeapOverFlewExpection());
        }
    }

    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true){
            list.add("Heap Over");
        }
    }*/
}
