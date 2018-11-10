package queueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
    如何仅用栈结构实现队列结构？
    如何仅用队列结构实现栈结构？
 */
public class StackAndQueueConvert {
    //如何仅用栈结构实现队列结构？使用先进后出的结构完成先进先出的结构
    public static class TwoStackToQueue{
        //压入数据的栈
        Stack<Integer> pushStack;
        //弹出数据的栈
        Stack<Integer> popStack;//只要注意一点：popStack不空，则pushStack不向popStack里面压数据

        public TwoStackToQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }
        public void push(int num){
            pushStack.push(num);
        }
        public Integer pop(){
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("The Stack is empty.");
            }else if(popStack.empty()){
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }
        public Integer peek(){
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("The Stack is empty.");
            }else if(popStack.empty()){
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }
    //如何仅用队列结构实现栈结构？Queue的一个实现类LinkedList
    public static class TwoQueueToStack{
        Queue<Integer> queue;
        Queue<Integer> help;
        public TwoQueueToStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }
        public void add(int num){
            this.queue.add(num);
        }
        public Integer pool(){
            if (queue.isEmpty()) {
                throw new RuntimeException("The queue is empty.");
            }
            while(queue.size() != 1){
                help.add(queue.poll());
            }
            int tmp = queue.poll();
            swap();
            return tmp;
        }
        public Integer peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("The queue is empty.");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int tmp = queue.poll();
            help.add(tmp);
            swap();
            return tmp;
        }

        private void swap() {
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
        }
    }
}
