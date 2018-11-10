package linked;

import java.util.List;

/*
    输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //循环两次链表
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k < 1){
            return null;
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (count < k){
            return null;
        }
        cur = head;
        while(count-- != k){
            cur = cur.next;
        }
        return cur;
    }
    //"尺子"做法:"建立"一个长度为k的尺子
    public ListNode FindKthToTailII(ListNode head,int k){
        if (head == null || k < 1) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if(last.next != null){
                last = last.next;
            }else {
                return null;
            }
        }
        while(last.next != null){
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int k = 1;
        System.out.println(new FindKthToTail().FindKthToTail(head,k).val);
        System.out.println(new FindKthToTail().FindKthToTailII(head,k).val);
    }
}
