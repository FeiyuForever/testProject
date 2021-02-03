package com.feiyu.data.test.thread;

/**
 * Created by xzhou.James on 2020/11/29
 *
 * 三个线程交替打印 ABC 十次
 */
public class StartThread1 {


    /**
     *  求余数 操作
     *  a%b = a - (a/b) * b;
     */

    private static Integer index = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(index > 10){
                        break;
                    }
                    if(index % 3 == 1){
                        System.out.println("A");
                        index++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(index > 10){
                        break;
                    }
                    if(index % 3 == 2){
                        System.out.println("B");
                        index++;
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(index > 10){
                        break;
                    }
                    if(index % 3 == 0){
                        System.out.println("C");
                        index++;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
