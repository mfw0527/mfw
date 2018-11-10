package sort;

import java.util.Arrays;
import java.util.LinkedList;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int[] array) {
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                list.add(i);
            }else {
                list.add(index,i);
                index++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
