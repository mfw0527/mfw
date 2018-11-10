package sort;

public class SmallSum {
    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr, 0, arr.length-1);
    }
    public static int mergeSort(int[] arr,int l,int r) {
        if(l == r)
            return 0;
        int mid = l + ((r - l)>>1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while(p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }
        for(i = 0;i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
    //������
    public static int comparator(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for(int i = 0;i < arr.length; i++) {
            for(int j = i + 1;j < arr.length; j++) {
                res += arr[i] < arr[j] ? arr[i] : 0 ;
            }
        }
        return res;
    }
    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)(maxSize * Math.random()) + 1];
        for(int i = 0;i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }
    public static int[] copyArray(int[] arr) {
        if(arr == null ) {
            return null;
        }
        int[] temp = new int[arr.length];
        int i = 0;
        while(i < arr.length) {
            temp[i] = arr[i++];
        }
        return temp;
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
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
//        boolean succeed = true;
//        for(int i = 0;i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            int s = smallSum(arr1);
//            int c = comparator(arr2);
//            if(s != c) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                System.out.println(s);
//                System.out.println(c);
//                break;
//            }
//        }
//        System.out.println(succeed);
        int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        int s = smallSum(arr);
        System.out.println(s);
        printArray(arr);
    }
}
