package practice;

public class NextMultiply {

    public static void main(String[] args) {
        // 输入数据
        String string = "1234567890";
        // 字符数据转化成数组数据
        char[] temp =string.toCharArray();
        int[] number =new int[15];
        for(int i=0;i<temp.length; i++) {
            number[i]=Integer.valueOf(temp[i]);
        }
        // 判断
        nextMultiply(number, 4);
    }
    public static void nextMultiply(int[] number, int n) {
        int result=1,max=0;
        int[] temp = new int[n];
        for(int i=0;i<number.length - 1; i++) {
            for(int j=0;j<n; j++) {
                result *= number[i+j];
                if(max < result) {
                    max = result;
                    temp[j] = number[i+j];
                }
            }
        }System.out.println(max);

    }


}