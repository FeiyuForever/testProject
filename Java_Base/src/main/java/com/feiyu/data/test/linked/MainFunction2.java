package com.feiyu.data.test.linked;

/**
 * Created by xzhou.James on 2020/11/26
 * 实现链表反转
 */
public class MainFunction2 {

    private Integer num = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        Node head3 = new Node(4);
        Node head4 = new Node(5);

        root.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;

        Node resultNode = getReverseNode(root);
        if (resultNode == null){
            System.out.println("链表为空");
        }
        Node node = resultNode;
        while (node != null){
            System.out.println(node.num);
            node = node.next;
        }
    }

    /**
     * 翻转链表  0->1->2->3->4
     *          4->3->2->1->0
     * @param head
     * @return
     */
    private static Node getReverseNode(Node head) {
        if (head == null) {
            return null;
        }
        /**
         * 思想  类似于CAS的思维
         */
        //之前的链表  的辅助链表，用于指针的切换，原先的链表减一
        Node previousNode = null;
        //当前的链表 每次新的链表加一
        Node currentNode = head;
        //最新的链表
        Node headNode = null;
        while (currentNode != null){
            Node next = currentNode.next;
            if(next == null){
                headNode = currentNode;
            }
            //切断上一个和下一个指针的连接
            currentNode.next = previousNode;
            //重新赋值，把指定的元素 -> 之前的链表换掉新链表元素
            previousNode = currentNode;
            currentNode = next;
        }
        return previousNode;
    }
}