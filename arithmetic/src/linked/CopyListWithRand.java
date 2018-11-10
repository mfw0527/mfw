package linked;

import java.util.HashMap;
import java.util.Map;

/*
复制含有随机指针节点的链表
【题目】 一种特殊的链表节点类描述如下：
public class Node { public int value; public Node next; public
Node rand;
public Node(int data) { this.value = data; }
}
Node类中的value是节点值，next指针和正常单链表中next指针的意义
一 样，都指向下一个节点，rand指针是Node类中新增的指针，这个指
针可 能指向链表中的任意一个节点，也可能指向null。 给定一个由
Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成
这个链表中所有结构的复制，并返回复制的新链表的头节点。 进阶：
不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)
内完成原问题要实现的函数。
 */
public class CopyListWithRand {
    public static class Node{
        int value;
        Node next;
        Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
    //利用map结构复制链表
    public static Node copyListWithRand(Node head){
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand1(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node newCur = null;
        //在"next"链中将结点复制一遍
        while(cur != null){
            //复制当前结点
            newCur = new Node(cur.value);
            //结点指向cur.next
            newCur.next = cur.next;
            //cur链接新建结点
            cur.next = newCur;
            //将指针移动到原链表cur结点的next结点
            cur = newCur.next;
        }
        cur = head;
        while(cur != null){
            newCur = cur.next;
            //复制结点的rand结点指向——对应的cur结点的rand结点的下一个结点
            newCur.rand = cur.rand == null ? null : cur.rand.next;
            //指向原链表的下一个结点
            cur = cur.next.next;
        }
        cur = head;
        Node res = cur.next;
        while(cur != null){
            //保存复制结点
            newCur = cur.next;
            //恢复原链表
            cur.next = cur.next.next;
            //链接新结点,构建复制链表
            newCur.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;
        }
        return res;
    }

//打印链表方法
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
//测试
    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand1(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand1(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
