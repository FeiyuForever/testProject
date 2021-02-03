package com.feiyu.data.practise.leetcode.huawei.linked;

/**
 * Created by xzhou.James on 2020/12/27
 * <p>
 * 实现链表的反转
 */
public class LinkedTest {

    public static void main(String[] args) {
        LinkedNode linkedNode1 = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(2);
        LinkedNode linkedNode3 = new LinkedNode(3);
        LinkedNode linkedNode4 = new LinkedNode(4);
        LinkedNode linkedNode5 = new LinkedNode(5);

        linkedNode1.node = linkedNode2;
        linkedNode2.node = linkedNode3;
        linkedNode3.node = linkedNode4;
        linkedNode4.node = linkedNode5;
        linkedNode5.node = null;

        LinkedNode rootNode = getNode(linkedNode1);
        if(rootNode != null){
            LinkedNode linkedNode = rootNode;
            while (linkedNode != null) {
                System.out.println(linkedNode.root);
                linkedNode = linkedNode.node;
            }
        }
    }

    /**
     * 链表的反转
     *
     * @param node
     * @return
     */
    private static LinkedNode getNode(LinkedNode node) {
        LinkedNode currentNode = null;
        LinkedNode previousNode = node;
        while (previousNode != null) {
            LinkedNode root = previousNode.node;
            previousNode.node = currentNode;
            //当前的  与 之前的链表节点 进行交换
            currentNode = previousNode;
            previousNode = root;
        }
        return currentNode;
    }
}
