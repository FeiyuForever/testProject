package com.feiyu.data.practise.leetcode.huawei.thread.notifyWait;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xzhou.James on 2021/1/2
 */
public class NiuKeThreadPrintString {

    //重入锁
    static ReentrantLock lock = new ReentrantLock();

    static Condition condition1 = lock.newCondition();

    static Condition condition2 = lock.newCondition();

    static Condition condition3 = lock.newCondition();

    static Condition condition4 = lock.newCondition();

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i = 0; i < num; i++) {
                            while (count % 4 != 0) {
                                condition1.await();
                            }
                            System.out.print("A");
                            count++;
                            condition2.signalAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i = 0; i < num; i++) {
                            while (count % 4 != 1) {
                                condition2.await();
                            }
                            System.out.print("B");
                            count++;
                            condition3.signalAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i = 0; i < num; i++) {
                            while (count % 4 != 2) {
                                condition3.await();
                            }
                            System.out.print("C");
                            count++;
                            condition4.signalAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
            Thread thread4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i = 0; i < num; i++) {
                            while (count % 4 != 3) {
                                condition4.await();
                            }
                            System.out.print("D");
                            count++;
                            condition1.signalAll();
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });

            thread1.start();

            thread2.start();

            thread3.start();

            thread4.start();

            try {
                thread4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
