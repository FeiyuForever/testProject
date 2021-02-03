package com.feiyu.data.practise.leetcode.huawei.thread.notifyAllWait;

import com.feiyu.data.practise.leetcode.huawei.exception.HeapOverFlewExpection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou.James on 2021/1/2
 * <p>
 * Java并发面试题：三个线程轮流打印十次abc
 * <p>
 * 用 synchronized + wait + notify || notifyAll 实现
 *
 * 1、lock.wait(); 当前对象释放锁 ,进入阻塞状态   ++++ -----  Thread.sleep(10) 不会释放锁
 * 2、lock.notify()；唤醒一个正在等待相应对象锁的线程，使其进入就绪队列，以便在当前线程释放锁后竞争锁，
 * 进而得到CPU的执行。
 *
 * notify使用时 （如果一个对象 --（线程数量 > 2） 会产生死锁） 两个线程不会产生
 *
 * 3、lock.notifyAll()； 唤醒所有正在等待相应对象锁的线程，使它们进入就绪队列，以便在当前线程释放锁后竞争锁，
 * 进而得到CPU的执行。
 *
 * 总结：
 *
 *  从以上描述可以得出：wait()、notify() 和 notifyAll()方法是 本地方法，并且为 final 方法，无法被重写；
 *  调用某个对象的 wait() 方法能让 当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）；
 *  调用某个对象的 notify() 方法能够唤醒 一个正在等待这个对象的monitor的线程，
 *  如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
 *  调用notifyAllAll()方法能够唤醒所有正在等待这个对象的monitor的线程。
 */
public class MainThreadFunction {

    private static int count = 1;

    public static void main(String[] args) throws RuntimeException {
        final Object lock = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 1) {
                            try {
                                //当前对象释放锁 ,进入阻塞状态 Thread.sleep(10) 不会释放锁
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A");
                        count++;
                        //该对象唤醒所有的 等待线程，让线程运行
                        //对于 我们是不可见的，黑盒运行
                        lock.notify();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("B");
                        count++;
                        lock.notify();
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        count++;
                        lock.notify();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
