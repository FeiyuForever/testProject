package com.feiyu.data.practise.leetcode.huawei.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

/**
 * Created by xzhou.James on 2021/1/3
 *
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
 * 线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，
 * ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 */
public class CnoditionPrintNum {

    private static int count = 1;

    private static Character A = 'A';

    private static Character B = 'B';

    private static Character C = 'C';

    private static Character D = 'D';

    //定义可 重入锁   true:公平锁     false:非公平锁
    private static ReentrantLock lock =  new ReentrantLock(true);

    //可重入锁  的condition  await signal signalAll 线程之间的通信
    private static Condition condition1 = lock.newCondition();

    private static Condition condition2 = lock.newCondition();

    private static Condition condition3 = lock.newCondition();

    private static Condition condition4 = lock.newCondition();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            getNumPrint(num);
        }
    }

    private static void getNumPrint(int num) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    lock.lock();
                    try {
                        while (count % 4 != 1){
                            condition1.await();
                        }
                        System.out.print(A);
                        count++;
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    lock.lock();
                    try {
                        while (count % 4 != 2){
                            condition2.await();
                        }
                        System.out.print(B);
                        count++;
                        condition3.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    lock.lock();
                    try {
                        while (count % 4 != 3){
                            condition3.await();
                        }
                        System.out.print(C);
                        count++;
                        condition4.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    lock.lock();
                    try {
                        while (count % 4 != 0){
                            condition4.await();
                        }
                        System.out.print(D);
                        count++;
                        condition1.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }).start();

        try {
            new Thread(() -> {
                System.out.println("join线程阻塞");
            }).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n"+"=================");

        /*new Thread(() -> {
            System.out.println("--线程的Lambda表达式测试--");
        }).start();*/
    }
}
