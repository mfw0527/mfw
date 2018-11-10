package sort;


import java.util.Arrays;

import static sort.BubbleSort.swap;

/*
    插入排序：由数组第二个数开始向后循环, 依次与前一个数比较,若较小则插入前一个数前面(即交换),继续与前面的数比较

    例：int[] arr = {7,8,1,5,6,3,4};
    比较方式：1.arr[0]与arr[1]比较，7<8无需交换 2.arr[1]与arr[2]比较，8>1交换，交换后arr[1]=1 3.arr[1]与arr[0]比较，7>1交换。以此类推
    过程：第一次循环：arr：7,8,1,5,6,3,4
          第二次循环：arr: 1,7,8,5,6,3,4
          ...
          第n-2次循环：arr：1,3,5,6,7,8,4
          第n-1次循环：arr：1,3,4,5,6,7,8
    时间复杂度O(N)--O(N^2)
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        //外层for循环，可以理解为“轮数”，也可以理解为要进行插入排序的元素下标
        for(int i = 1; i < arr.length ; i++){
            //内层for循环，将要操作的“元素”与前面的数依次比价。循环停止条件：已经被“插入”到arr[0],或前一个数比操作的“元素”小
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    public static int[] generateRandomArray(int maxSize ,int maxValue){
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1) - Math.random() * maxValue);
        }
        return arr;
    }
    public static int[] copyArray(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static boolean isEquals(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null)||(arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length ; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void printArray (int[] arr) {
        if(arr == null)
            return;
        for(int i = 0 ;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 200;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if(!isEquals(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                break;
            }
        }
        System.out.println(succeed);
        int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
