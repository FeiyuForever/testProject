package com.feiyu.data.practise.middenrank.sync;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xzhou.James on 2020/10/1
 */
public class ThreadSync {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private static final String name = "飞宇";

    private static Integer num = 1;

    public static void main(String[] args) {
        System.out.println("游戏开始");
        for (int i = 0; i < 10; i++) {
            gameStart(i);
        }
    }

    private static void gameStart(int i) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    getName(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void getName(int i) {
        System.out.println("人物名称：" + name + "(" + i + ")" + " :: => " + Thread.currentThread().getName());
    }

}
