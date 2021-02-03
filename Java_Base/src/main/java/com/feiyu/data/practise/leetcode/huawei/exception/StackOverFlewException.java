package com.feiyu.data.practise.leetcode.huawei.exception;

import java.util.Stack;

/**
 * Created by xzhou.James on 2020/12/27
 */
public class StackOverFlewException {

    public static void main(String[] args) {
        getDiGui(new int[]{1,5,36,45});
    }

    private static void getDiGui(int[] ints) {
        getDiGui(ints);
    }
}
