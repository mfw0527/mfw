package practice;

public class FindZero {
    public static int findZero(int n){
        return n/5 + n/25 + n/125 + n/625;
    }
    public static long findZero1(int n){
        long res = 1;
        while (n > 0){
            res *= n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findZero(10));
        System.out.println(findZero1(10));
    }

}
