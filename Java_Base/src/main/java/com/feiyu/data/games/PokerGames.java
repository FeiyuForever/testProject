package com.feiyu.data.games;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author xzhou.James
 * @Date 2020/8/29  9:31
 *
 * 四人抢纸牌游戏
 * 花色用 Ａ　Ｂ　Ｃ　Ｄ表示
 * 1 2 3 4 5 6 7 8 9 10 11 12 13
 */
public class PokerGames {

    /**
     * 启动指令
     */
    private static final String ENTER = "start";

    private static ThreadPoolExecutor threadPoolExecutor = null;

    static {
        threadPoolExecutor = new ThreadPoolExecutor(
                4,
                8,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    public static void main(String[] args) throws Exception{
        System.out.println("===========抢大牌游戏开始============");
        System.out.println("请输入【start】开始抢牌：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bufferedReader.readLine()) != null){
            if(str.equals(ENTER)){
                startGetPoker();
            }else{
                System.out.println("输入指令有误,请重新输入！");
            }
        }
    }

    /**
     * 开始抢牌
     */
    private static void startGetPoker() {
        //拿到扑克牌
        LinkedList<String> linkedList = Poker.makePoker();
        //定义线程个数
        getPlayerMethods(linkedList);
    }

    private static void getPlayerMethods(LinkedList<String> linkedList) {

    }
}