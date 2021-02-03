package com.feiyu.data.thread.dto;

import java.util.LinkedList;

/**
 * create by xzhou.James on 2020/8/30
 */
public class Poker {

    /**
     * 名称
     */
    private String name = "";
    /**
     * 索引
     */
    private Integer index = 0;
    /**
     * 纸牌集合
     */
    private static LinkedList<String> linkedList = new LinkedList<String>();

    public Poker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public static LinkedList<String> getLinkedList() {
        return linkedList;
    }

    public static void setLinkedList(LinkedList<String> linkedList) {
        Poker.linkedList = linkedList;
    }

}
