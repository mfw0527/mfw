package queueAndStack;

import java.util.Stack;
/*
    用数组结构实现大小固定的队列和栈
 */
public class ArrayToStackQueue {
    //用数组结构实现大小固定的栈
    public static class ArrayStack{
        Integer[] arr;
        Integer size;
        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0.");
            }
            this.arr = new Integer[initSize];
            size = 0;
        }
        public void push(int num){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The Stack is full.");
            }
            this.arr[size++] = num;
        }
        public Integer pop(){
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The Stack is Empty.");
            }
            return arr[--size];
        }
        //peek() 查看栈顶的数,不删除
        public Integer peek(){
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }
    }
    //用数组结构实现固定大小的队列
    public static class ArrayQueue{
        Integer[] arr;
        //记录队头
        Integer total;
        //记录队尾
        Integer end;
        Integer size;
        public ArrayQueue(int initSize){
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0.");
            }
            arr = new Integer[initSize];
            total = 0;
            end = 0;
            size = 0;
        }
        public void push(int num){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The Queue is full.");
            }
            size++;
            arr[end] = num;
            end = end == arr.length - 1 ? 0 : end + 1;
        }
        public Integer peek(){
            if (size == 0) {
                return null;
            }
            return arr[total];
        }
        public Integer poll(){
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The Queue is empty.");
            }
            size--;
            int tmp = total;
            total = total == arr.length - 1 ? 0 : total + 1;
            return arr[tmp];
        }
    }

}
