package com.feiyu.data.test.linked;

/**
 * Created by xzhou.James on 2020/11/26
 */
public class LinkedNode {

    private Integer node;
    private LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(Integer node) {
        this.node = node;
    }

    public LinkedNode(Integer node, LinkedNode next) {
        this.node = node;
        this.next = next;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
