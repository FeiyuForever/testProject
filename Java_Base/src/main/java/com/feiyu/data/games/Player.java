package com.feiyu.data.games;

import java.util.LinkedList;

/**
 * @Author xzhou.James
 * @Date 2020/8/29  10:47
 *
 * 玩家 model
 */
public class Player implements Runnable{

    /**
     * 线程名称
     */
    private String name;
    /**
     * 翻牌次数
     */
    private Integer turnOver;
    /**
     * 总分数
     */
    private Integer grade;
    /**
     * 花费时间
     */
    private Integer takeTime;
    /**
     * 纸牌序列
     */
    private LinkedList<String> sortPoker;

    public Player(String name, LinkedList<String> sortPoker) {
        this.name = name;
        this.sortPoker = sortPoker;
    }

    public Player(String name, Integer turnOver, Integer grade, Integer takeTime, LinkedList<String> sortPoker) {
        this.name = name;
        this.turnOver = turnOver;
        this.grade = grade;
        this.takeTime = takeTime;
        this.sortPoker = sortPoker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(Integer turnOver) {
        this.turnOver = turnOver;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Integer takeTime) {
        this.takeTime = takeTime;
    }

    public LinkedList<String> getSortPoker() {
        return sortPoker;
    }

    public void setSortPoker(LinkedList<String> sortPoker) {
        this.sortPoker = sortPoker;
    }

    @Override
    public void run() {

    }
}
