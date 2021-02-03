package com.feiyu.data.test.thread;

/**
 * Created by xzhou.James on 2020/11/29
 */
public class StartThread {

    public static void main(String[] args) {

        TaskJob taskJob1 = new TaskJob("A");
        TaskJob taskJob2 = new TaskJob("B");
        TaskJob taskJob3 = new TaskJob("C");

        Thread thread1 =new Thread(taskJob1,"线程1");
        Thread thread2 =new Thread(taskJob2,"线程2");
        Thread thread3 =new Thread(taskJob3,"线程3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("方法最后执行");

        System.exit(0);
    }
}
