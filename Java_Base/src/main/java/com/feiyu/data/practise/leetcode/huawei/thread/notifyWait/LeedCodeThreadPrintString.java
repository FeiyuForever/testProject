package com.feiyu.data.practise.leetcode.huawei.thread.notifyWait;

import java.util.Vector;

/**
 * Created by xzhou.James on 2021/1/2
 *
 *  题目描述
 *  问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
 *  线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，
 *  ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 *  接口说明：
 */
public class LeedCodeThreadPrintString {

    private static int count = 1;

    private static Character A = 'A';

    private static Character B = 'B';

    private static Character C = 'C';

    private static Character D = 'D';


    public static void main(String[] args) {
        getStringName(30);
    }

    private static void getStringName(int flag) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < flag; i++) {
                        while (count % 4 != 1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(A);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < flag; i++) {
                        while (count % 4 != 2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(B);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < flag; i++) {
                        while (count % 4 != 3){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(C);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < flag; i++) {
                        while (count % 4 != 0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(D);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        /*try {
            new Thread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
