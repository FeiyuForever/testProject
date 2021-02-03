package com.feiyu.data.test.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou.James on 2020/11/26
 *
 * 实现链表反转
 */
public class MainFunction1 {

    private Integer num = 0;

    public static void main(String[] args) {
        LinkedNode root = new LinkedNode();
        LinkedNode head1 = new LinkedNode();
        LinkedNode head2 = new LinkedNode();
        LinkedNode head3 = new LinkedNode();
        LinkedNode head4 = new LinkedNode();

        root.setNode(1);
        head1.setNode(2);
        head2.setNode(3);
        head3.setNode(4);
        head4.setNode(5);

        root.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head4);

        LinkedNode resultNode = getReverseNode(root);
        if (resultNode == null){
            System.out.println("链表为空");
        }
        LinkedNode node = resultNode;
        while (node != null){
            System.out.println(node.getNext());
            node.getNext();
        }
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private static LinkedNode getReverseNode(LinkedNode head) {
        if(head == null){
            return null;
        }
        //利用栈的先进后出
        Stack<LinkedNode> stack = new Stack<LinkedNode>();
        LinkedNode oldNde = head;
        while (oldNde != null){
            stack.push(oldNde);
            oldNde = oldNde.getNext();
        }
        LinkedNode newNode = getNewNodeList(stack);
        return newNode;
    }

    /**
     * 填充链表  栈没有办法递归
     * @param stack
     * @return
     */
    private static LinkedNode getNewNodeList(Stack<LinkedNode> stack ) {
        LinkedNode nextNode = new LinkedNode();
        if(stack.empty()){
            return nextNode;
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            LinkedNode elem = stack.pop();
            Integer node = elem.getNode();
            list.add(node);
        }
        nextNode =  getNewNextNode(list);
        return nextNode;
    }

    private static LinkedNode getNewNextNode(List<Integer> list) {
        LinkedNode nextNode = new LinkedNode();
        int count = 0;
        for (Integer elem:list) {
            count++;
            if(nextNode.getNode() == null){
                nextNode = new LinkedNode(elem,new LinkedNode());
            }else{
                LinkedNode newNode = getNextNode(nextNode,elem);//node=4 next = null |
                if(elem.equals(list.get(1))){
                    nextNode.setNext(newNode);
                }else{
                    continue;
                }
            }
        }
        return nextNode;
    }

    private static LinkedNode getNextNode(LinkedNode nextNode, Integer num) {
        LinkedNode node = new LinkedNode(num);
        if(nextNode.getNext() == null && nextNode.getNode() == null){
            return node;
        }else if(nextNode.getNext() == null){
            nextNode.setNext(node);
            return node;
        }
        return getNextNode(nextNode.getNext(),num);
    }
}
