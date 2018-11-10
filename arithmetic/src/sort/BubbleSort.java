package sort;

import java.util.Arrays;
import java.util.Stack;
public class BubbleSort {
    /*
    冒泡排序，循环数组，两两比较，每一次循环都能将 未排序数组部分最大数 替换到 未排序部分数组的尾部

    例：int[] arr = {7,8,1,5,6,3,4};
    比较方式：1.arr[0]与arr[1]比较，7>8无需交换 2.arr[1]与arr[2]比较,8>1交换,交换后arr[2]=8 3.arr[2]与arr[3]比较，8>5交换，交换后arr[3]=8 以此类推
    过程：第一次循环后 arr :7,1,5,6,3,4,8
         第二次循环后  arr :1,5,6,3,4,7,8
         ...
         第n-2次循环后 arr :1,3,4,5,6,7,8
         第n-1次循环后 arr :1,3,4,5,6,7,8
    时间复杂度O(N^2)
     */
    public static void bubbleSort(int[] arr){
        //判断数组是否为空或是否只有一个元素，若是，直接返回。用处仅为提高程序效率
        if(arr == null || arr.length < 2){
            return;
        }
        //外层for循环，代表“轮数”，因为第n-1次比较，同时确定最小数和倒数第二小的数。因此只需要循环n-1次
        for (int i = arr.length - 1; i > 0; i--) {
            //内层for循环，代表当前“轮数”需要进行的“比较次数”。因为每次都会确定一个“最大数”，且最后两个数仅需比较一次，因此只需比较n-1-j次
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp ;
//        利用与运算交换，可以节省额外空间，不用定义新变量。与运算：0^0=0  0^1=1  1^0=1  1^1=0.任何数与其本身^运算都等于0，任何数与0^运算都等于数本身
//        与运算交换缺点：若交换元素为本身，即自己与自己交换会丢失数据（本身变为0）
//        arr[i] = arr[i]^arr[j];
//        arr[j] = arr[i]^arr[j];
//        arr[i] = arr[i]^arr[j];
    }

//  一种测试方式————比较器
    //利用自带工具类排序作为比较对象
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    //生成随机数组
    public static int[] generateRandomArray(int maxSize ,int maxValue){
        //定义随机长度数组
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        //为数组随机赋值
        for (int i = 0; i < arr.length; i++) {
            //减法是为了生成负数
            arr[i] = (int)(Math.random() * (maxValue + 1) - Math.random() * maxValue);
        }
        return arr;
    }
    //copy数组方法
    public static int[] copyArray(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    //比较数组是否相等的方法
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
    //打印数组方法
    public static void printArray (int[] arr) {
        if(arr == null)
            return;
        for(int i = 0 ;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //主方法，测试
    public static void main(String[] args) {
        //测试次数
        int testTime = 100000;
        //生成数组的最大长度
        int maxSize = 100;
        //生成数组最大的值
        int maxValue = 200;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            //生成随机数组
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            //复制生成的数组
            int[] arr2 = copyArray(arr1);
            //自定义排序方法排序
            bubbleSort(arr1);
            //Arrays方法排序
            comparator(arr2);
            //比较
            if(!isEquals(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                break;
            }
        }
        System.out.println(succeed);
        int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);

    }

}
