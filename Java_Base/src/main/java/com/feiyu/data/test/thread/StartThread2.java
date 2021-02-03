package com.feiyu.data.test.thread;

/**
 * Created by xzhou.James on 2020/11/29
 *
 * 三个线程交替打印 ABC 十次
 */
public class StartThread2 {

    static int index = 1;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 4; i++) {
                        while (index % 3 != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName()+":"+"A");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 4; i++) {
                        while (index % 3 != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName()+":"+"B");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 4; i++) {
                        while (index % 3 != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName()+":"+"C");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
