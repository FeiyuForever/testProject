package com.feiyu.data.test.linked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhou.James on 2020/11/26
 *
 * 实现链表反转
 */
public class MainFunction {

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode();
        LinkedNode resultNode = getReverseNode(linkedNode);
        if (resultNode == null){
            System.out.println("链表为空");
        }
        LinkedNode node = resultNode;
        while (node != null){
            System.out.println(node.getNext());
            node.getNext();
        }
    }

    private static LinkedNode getReverseNode(LinkedNode head) {
        if(head == null){
            return null;
        }
        LinkedNode linkedNode = null;
        List<LinkedNode> list = new ArrayList<>();
        LinkedNode existNode = head;
        while (existNode != null){
            list.add(existNode);
            existNode.getNext();
        }
        Collections.reverse(list);
        for (LinkedNode elem:list) {
            linkedNode.setNext(elem);
        }
        return linkedNode;
    }
}
