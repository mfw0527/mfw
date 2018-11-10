package queueAndStack;

import java.util.Stack;

/*
实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
回栈中最小元素的操作。
【要求】
1．pop、push、getMin操作的时间复杂度都是O(1)。
2．设计的栈类型可以使用现成的栈结构。
 */
public class GetMinStack {
    /*
    第一种实现方式：
        辅助栈（最小栈）size <= 数栈size
     */
    public static class GetMinStack1{
        Stack<Integer> stack;
        Stack<Integer> minStack;
        public GetMinStack1(){
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }
        public void push(int num){
            this.stack.push(num);
            if (this.minStack.empty()){
                this.minStack.push(num);
            }else if(minStack.peek() >= num){
                this.minStack.push(num);
            }
        }
        public Integer pop(){
            if(this.stack.empty()){
                throw new RuntimeException("The stack is empty.");
            }
            int tmp = this.stack.pop();
            if(tmp == this.minStack.peek()){
                this.minStack.pop();
            }
            return tmp;
        }
        public Integer getMin(){
            if(this.minStack.empty()){
                throw new RuntimeException("The stack is empty.");
            }
            return this.minStack.peek();
        }
    }

    /*
    第二种实现方式：
        辅助栈(最小栈)size == 数栈size
     */
    public static class GetMinStack2{
        Stack<Integer> stack;
        Stack<Integer> minStack;
        public GetMinStack2(){
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }
        public Integer getMin(){
            if (this.minStack.empty()) {
                throw new RuntimeException("The Stack is empty.");
            }
            return this.minStack.peek();
        }
        public void push(int num){
            if(this.minStack.empty()){
                this.minStack.push(num);
            }else if(this.getMin() > num){
                this.minStack.push(num);
            }else {
                this.minStack.push(this.getMin());
            }
            this.stack.push(num);
        }
        public Integer pop(){
            if (this.stack.empty()) {
                throw new RuntimeException("The stack is empty.");
            }
            this.minStack.pop();
            return this.stack.pop();
        }
    }

    public static void main(String[] args) {
        GetMinStack1 stack1 = new GetMinStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        GetMinStack2 stack2 = new GetMinStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());

    }
}
