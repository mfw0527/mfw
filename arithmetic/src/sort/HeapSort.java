package sort;

import java.util.Arrays;

import static sort.BubbleSort.swap;

/*
    堆排序:堆排序(Heapsort)是指利用堆积树（堆）这种 数据结构所设计的一种排序算法，它是选择排序的一种。
    可以利用 数组的特点快速定位指定索引的元素。堆分为大根堆和小根堆，是完全二叉树。大根堆的要求是每个节点的值都不大于其父节点的值
    用大根堆排序的基本思想
① 先将初始文件R[1..n]建成一个大根堆，此堆为初始的无序区
② 再将关键字最大的记录R[1]（即堆顶）和无序区的最后一个记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，且满足R[1..n-1].keys≤R[n].key
③由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。然后再次将R[1..n-1]中关键字最大的记录R[1]和该区间的最后一个记录R[n-1]交换，
由此得到新的无序区R[1..n-2]和有序区R[n-1..n]，且仍满足关系R[1..n-2].keys≤R[n-1..n].keys，同样要将R[1..n-2]调整为堆。
……
直到无序区只有一个元素为止。
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //建堆①
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
       //调整堆
        int size = arr.length;
        //②
        swap(arr, 0, --size);
        while(size > 0){
            //③
            heapify(arr, 0, size);
            swap(arr,0,--size);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        //当前节点的左子树下标
        int l = 2 * i + 1;
        //当前节点不存在左子树，停止循环
        while(l < size){
            //确定无序区的最大数下标
            int largest = l + 1 < size && arr[l] < arr[l + 1] ? l + 1: l;
            largest = arr[largest] < arr[i] ? i : largest;
            //如果largest == i，证明当前堆已经是大根堆
            if (largest == i) {
                break;
            }
            swap(arr,largest,i);
            //继续比较，直到确定堆为大根堆为止
            i = largest;
            l = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]){
            swap(arr, index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }




    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for(int i = 0;i < arr.length;i++) {
            arr[i] = (int)((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] newArray = new int[arr.length];
        for(int i = 0;i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    public static boolean isEqual(int[] arr1,int[] arr2) {
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
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0;i < testTime ;i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                break;
            }
        }
        System.out.println(succeed?true:false);

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
