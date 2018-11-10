package linked;

import java.util.ArrayList;
import java.util.Stack;

/*
判断一个链表是否为回文结构
【题目】 给定一个链表的头节点head，请判断该链表是否为回
文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
15->6->15，返回true。 1->2->3，返回false。
进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
度达到O(1)。
 */
public class IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }
    //额外空间O(n)
    public static boolean isPalindromeList1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(!stack.isEmpty()){
            if(stack.pop().value != cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    //额外空间O(n/2)
    public static boolean isPalindromeList2(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node one = head.next;
        Node two = head;
        while(two.next != null && two.next.next != null){
            one = one.next;
            two = two.next.next;
        }
        while(one != null){
            stack.push(one);
            one = one.next;
        }
        while(!stack.empty()){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //额外空间O(1)
    public static boolean isPalindromeList3(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Node one = head;
        Node two = head;
        //寻找mid
        while(two.next != null && two.next.next != null){
            one = one.next;
            two = two.next.next;
        }
        //反转右半部分链表
        Node pre = null;
        while (one != null) {
            two = one.next;
            one.next = pre;
            pre = one;
            one = two;
        }
        one = pre;
        two = head;
        //比较
        boolean res = true;
        while (two != null && pre != null) {
            if(two.value != pre.value){
                res = false;
                break;
            }
            two = two.next;
            pre = pre.next;
        }
        //将链表复原
        pre = null;
        while (one != null) {
            two = one.next;
            one.next = pre;
            pre = one;
            one = two;
        }
        return res;
    }

    //打印方法
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

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindromeList3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


}
