package com.feiyu.data.practise.leetcode.huawei.thread.notifyWait;

/**
 * Created by xzhou.James on 2021/1/2
 */
public class TaskJobUtils {

    public static void printName(Integer num){
        num.notify();
        try {
            num.wait();
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
