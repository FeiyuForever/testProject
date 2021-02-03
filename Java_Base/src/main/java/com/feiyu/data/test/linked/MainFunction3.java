package com.feiyu.data.test.linked;

/**
 * Created by xzhou.James on 2020/11/26
 * 实现链表反转
 */
public class MainFunction3 {

    private Integer num = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        Node head3 = new Node(4);
        Node head4 = new Node(5);
        Node head5 = new Node(6);

        root.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        Node resultNode = getReverseNode(root);
        if (resultNode == null) {
            System.out.println("链表为空");
        }
        Node node = resultNode;
        while (node != null) {
            System.out.println(node.num);
            node = node.next;
        }
    }

    /**
     * 翻转链表  0->1->2->3->4
     * 4->3->2->1->0
     *
     * @param head
     * @return
     */
    private static Node getReverseNode(Node head) {
        if (head == null) {
            return null;
        }
        Node reverseNode = null;
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            //切掉原来的指针的关系 (1 -> 2 ... )
            currentNode.next = reverseNode;
            //原来的链表 和 现在的进行交换
            reverseNode = currentNode;
            //next  重新赋值
            currentNode = next;
        }
        return reverseNode;
    }
}