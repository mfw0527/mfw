package sort;

import java.util.Arrays;
/*
    归并排序: 将有序的两部分合并(递归).一个不断的二分,然后不断的合并的过程.
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        //base case 可以理解为递归,进行到什么程度为止
        if (l == r) {
            return;
        }
        //取中间下标
        int mid = l + ((r - l)>>1);
        //递归左侧
        mergeSort(arr,l,mid);
        //递归右侧
        mergeSort(arr,mid+1,r);
        //合并
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        //临时数组,用来存储排序后的数组
        int[] tmp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            tmp[i++] = arr[p1++];
        }
        while(p2 <= r){
            tmp[i++] = arr[p2++];
        }
        for(i = 0;i < tmp.length;i++){
            arr[l + i] = tmp[i];
        }
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }
    public static int[] copyArray(int[] arr) {
        if(arr == null)
            return null;
        int[] newArray = new int[arr.length];
        for(int i = 0;i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }
    public static void printArray(int[] arr) {
        if(arr == null)
            return;
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static boolean isEqual(int[] arr1,int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null) {
            return true;
        }
        for(int i = 0 ;i < arr1.length; i++ ) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        int[] arr1 = generateRandomArray(maxSize, maxValue);
        int[] arr2 = copyArray(arr1);
        mergeSort(arr1);
        comparator(arr2);
        for(int i = 0;i < testTime ; i++) {
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed?true:false);
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
