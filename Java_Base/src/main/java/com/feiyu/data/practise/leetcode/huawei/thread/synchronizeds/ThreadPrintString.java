package com.feiyu.data.practise.leetcode.huawei.thread.synchronizeds;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/2
 *
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
 * 线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，
 * ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 */
public class ThreadPrintString {

    public static void main(String[] args) throws Exception {
        String line = getLine(100);
        System.out.println(line);
    }

    public static String getLine(int num) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            Stack<Character> stack;
            Thread th1;
            Thread th2;
            Thread th3;
            Thread th4;
            synchronized (Integer.valueOf(i)) {
                //synchronized (Integer.valueOf(i)) {
                stack = new Stack<Character>();
                th1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //sb.append(stack.pop());
                        sb.append('A');
                    }
                });
                th1.start();
                //}
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (Integer.valueOf(i)) {
                th2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //stack.push('C');
                        sb.append('B');
                    }
                });
                th2.start();
                //}
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (Integer.valueOf(i)) {
                th3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //stack.push('B');
                        sb.append('C');
                    }
                });
                th3.start();
                //}
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //th4
                //synchronized (Integer.valueOf(i)) {
                th4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //stack.push('A');
                        sb.append('D');
                    }
                });
                th4.start();
                //}
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            /*while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }*/
        }

        return sb.toString();
    }
}
