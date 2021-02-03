package com.feiyu.data.practise.leetcode.huawei.thread.notifyWait;

/**
 * Created by xzhou.James on 2021/1/2
 *
 * 两个线程 顺序打印 10个数
 */
public class WaitAndNotifyChannel {

    private static int count = 1;

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (lock){
                   for (int i = 1; i <= 10; i++) {
                       if(count > 10){
                           System.exit(0);
                       }
                       while (count % 2 == 0){
                           //TaskJobUtils.printName(i);
                           try {
                               lock.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       System.out.println(count);
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
                    for (int i = 1; i <= 10; i++) {
                        if(count > 10){
                            System.exit(0);
                        }
                        while (count % 2 == 1){
                            //TaskJobUtils.printName(i);
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(count);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        }).start();
     }
}
