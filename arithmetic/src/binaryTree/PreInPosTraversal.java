package binaryTree;
import java.util.Stack;

/*
    实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式
 */
public class PreInPosTraversal {
    public static class Node{
        int value;
        Node right;
        Node left;
        public Node(int data){
            this.value = data;
        }

    }
    //递归遍历二叉树
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(Node head){
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
    //非递归遍历二叉树
    public static void preOrderUnRecurI(Node head){
        System.out.print("pre-order : ");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while(!stack.empty()){
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
    }
    public static void preOrderUnRecurII(Node head){
        System.out.print("pre-order :");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || head != null) {
            if(head != null){
                stack.push(head);
                System.out.print(head.value + " ");
                head = head.left;
            }else{
                head = stack.pop();
                head = head.right;
            }
        }
    }
    public static void inOrderUnRecur(Node head){
        System.out.print("in-order :");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.empty() || head != null){
            if(head != null){//左子树不为空,则一直将左子树压栈     //*若弹栈结点的右子树不为空，循环右子树
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();//左子树为空，则弹栈      //*若弹栈结点的右子树为空则继续弹栈
                System.out.print(head.value + " ");//打印弹出结点值
                head = head.right;//*弹栈结点的右子树
            }
        }

    }
    //方法思想：先序遍历的顺序是 父->左->右   ， 后序遍历结果的逆序是 父->右->左
    public static void posOrderUnRecurI(Node head){
        System.out.print("pos-order :");
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(head);
        while(!stack.empty()){
            head = stack.pop();
            help.push(head);
            if(head.left != null){
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while(!help.empty()){
            System.out.print(help.pop().value + " ");
        }
    }
    public static void posOrderUnRecurII(Node head){
        System.out.print("pos-order :");
        if (head == null) {
            return;
        }
        Node cur = null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.empty()){
            cur = stack.peek();
            //判断当前节点的左子树是否为空 且 是否遍历过该节点的左右子树
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
                //判断当前结点的右子树是否为空 且是否 是否遍历过该节点的右子树
            } else if (cur.right != null && head != cur.right) {
                stack.push(cur.right);
            }else {
                System.out.print(stack.pop().value + " ");
                //充当已遍历过的标记
                head = cur;
            }
        }
    }


    //测试
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecurI(head);
        System.out.println();
        preOrderUnRecurII(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println();
        posOrderUnRecurI(head);
        System.out.println();
        posOrderUnRecurII(head);

    }

}
