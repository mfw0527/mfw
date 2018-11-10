package sort;

import java.util.Arrays;

import static sort.BubbleSort.comparator;
import static sort.BubbleSort.swap;
/*
    快速排序：
        原理：将一段区域内的数排列为小于、等于、大于的排列方式。递归得到有序数组。
    例：int[] arr = {7,8,5,2,1,3,6,9};
    比较方式：普通快排是每轮将当前区域最末尾的数作为p进行partition过程。优化之后，每轮随机从当前区域选择一个数进行partition过程
    过程：1.p = 9;排序后7,8,5,2,1,3,6,9
          2.p = 6;排序后3,1,5,2,6,7,8,9
          3.6的左部分p = 2;6的右部分p = 8;排序后1,2，3，5,6,7,8,9
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //优化快排的选数过程。每轮排序所用的p愈接近中位数，排序效率愈加高
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            //进行partition过程
            int[] partition = partition(arr, l, r);
            //对左边继续进行快排，即partition过程
            quickSort(arr,l,partition[0] - 1);
            //对右边继续进行快排
            quickSort(arr,partition[1] + 1,r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l -1;
        int more = r;
        while (l < more) {
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more,l);
            }else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less + 1, more};
    }
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }

}
