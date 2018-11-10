package linked;

import java.util.ArrayList;

/*
将单向链表按某值划分成左边小、中间相等、右边大的形式
【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5-
>1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总
之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求。
进阶： 在原问题的要求之上再增加如下两个要求。
在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左 到右的
顺序与原链表中节点的先后次序一致。 例如：链表9->0->4->5->1，pivot=3。
调整后的链表是0->1->9->4->5。 在满足原问题要求的同时，左部分节点从左到
右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再
讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，
最后出现5。
如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */
public class SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }
    //额外空间复杂度O（N） （借用数组存储链表节点）
    public static Node smallerEqualBigger1(Node head,int pivot){
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        Node cur = head;
        //获取链表长度
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        cur = head;
        //将链表存入数组
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        //partition数组
        i = nodes.length;
        int less = -1;
        int index = 0;
        while(index < i){
            if(nodes[index].value < pivot){
                swap(nodes,++less,index++);
            }else if(nodes[index].value > pivot){
                swap(nodes,--i,index);
            }else {
                index++;
            }
        }
        //重新连接链表
        i = 0;
        while(i != nodes.length - 1){
            nodes[i].next = nodes[i + 1];
            i++;
        }
        nodes[i].next = null;
        return nodes[0];
    }
    //额外空间复杂度O（1）
    public static Node smallerEqualBigger2(Node head,int pivot){
        Node sH = null;//value小于pivot的结点连接成的链表的头
        Node sT = null;//value小于pivot的结点连接成的链表的尾
        Node eH = null;//value等于pivot的结点连接成的链表的头
        Node eT = null;//value等于pivot的结点连接成的链表的头
        Node bH = null;//value大于pivot的结点连接成的链表的头
        Node bT = null;//value大于pivot的结点连接成的链表的头
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;
                }
            }else if(head.value == pivot){
                if (eH == null) {
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = eT.next;
                }
            }else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sT != null ? sH : eH != null ? eH : bH ;

    }
    private static void swap(Node[] nodes, int i, int i1) {
        Node tmp = nodes[i];
        nodes[i] = nodes[i1];
        nodes[i1] = tmp;
    }

    //打印链表方法
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    //测试
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = smallerEqualBigger1(head1, 5);
        head1 = smallerEqualBigger2(head1, 5);
        printLinkedList(head1);
    }
}
