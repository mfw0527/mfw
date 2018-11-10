package sort;

import static sort.BubbleSort.swap;
/*
    荷兰国旗问题
    问题转化:
        写一个方法，使数组中大于p的数都在右边，小于p的数都在左边，等于p的数都在中间
    思路：
        arr[0] arr[1] arr[2] arr[3] arr[4] arr[5] arr[6]
   less（-1）:小于p的界限下标                          more（arr.length)：大于p的界限下标
   1.定义一个less，使下标小于less的数，值都小于p。 定义一个more，使下标大于more的数，值都大于p。
   2.定义一个index，循环数组，若下标为index的数小于p，则与++less交换，index++。
   3.若下标为index的数大于p，则与--more交换，index不变（因为交换过来的数还没有与p比较过）。
   4.若下标为index的数等于p，则index++。
 */
public class NetherLandsFlag {
    public static int[] partition(int[] arr, int l, int r, int p){
        //小于p的数值范围 的最大下标
        int less = l - 1;
        //大于p的数值范围 的最小下标
        int more = r ;
        //当前数下标
        int index = 0;
        while(index < more){
            if(arr[index] > p){
                //若下标为index的数大于p，则与--more交换，index不变（因为交换过来的数还没有与p比较过）
                swap(arr,--more,index);
            } else if (arr[index] < p) {
                //若下标为index的数小于p，则与++less交换，index++
                swap(arr,++less,index++);
            }else {
                //若下标为index的数等于p，则index++。
                index++;
            }
        }
        //返回等于p的数值下标范围。若数组内存在p，则less+1<more-1。若数组内不存在p，则less+1>more-1
        return new int[]{less + 1,more - 1};
    }

    // for test
    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)(maxSize * Math.random() + 1)];
        for(int i = 0;i < arr.length;i++) {
            arr[i] = (int)(maxValue * Math.random());
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        if(arr == null)
            return;
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int p = (int)(maxValue * Math.random());
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        int[] result = partition(arr, 0, arr.length, p);
        printArray(arr);
        System.out.println(p);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
