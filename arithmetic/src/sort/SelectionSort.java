package sort;

import java.util.Arrays;

import static sort.BubbleSort.swap;

/*
    选择排序：每次循环数组找出一个最大或最小值交换到数组最前或最后,再继续循环数组。已排序部分不循环

    理解比较简单就不举例了
 */

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //外层for循环，“轮数”。
        for(int i = 0 ; i < arr.length - 1; i++){
            //存储最小数下标，先假定为数组开始循环的位置。
            int minIndex = i;
            //将假定的“当前最小数”依次与其他数比较，若“其他数”较小，记录下标。
            for(int j  = i + 1;j < arr.length ; j++){
                //记录最小数下标
//                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //将最小数交换到数组开始循环的位置
            swap(arr,minIndex,i);
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
            selectionSort(arr1);
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
        selectionSort(arr);
        printArray(arr);
    }
}
