package linked;
/*
反转单向和双向链表
【题目】 分别实现反转单向链表和反转双向链表的函数。
【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间
复杂度要求为O(1)
 */
public class ReverseList {
    //单向链表结点结构
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    //反转单向链表
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双向链表结点结构
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value){
            this.value = value;
        }
    }
    //反转双向链表
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    //打印单向链表的方法
    public static void printLinkedList(Node head){
        System.out.println("linked list :");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    //打印双向链表的方法
    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println("Double linked list :");
        DoubleNode end = null;
        while(head != null){
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while(end != null){
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }


    //测试
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }
}
