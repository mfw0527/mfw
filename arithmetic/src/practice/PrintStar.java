package practice;
/*
    边长为n的菱形
 */
public class PrintStar {
    public static void printStar(int n){
        int z = (2*n - 1)/2;
        int y = (2*n - 1)/2;
        while(z >= 0){
            print(z--,y++,n);
            System.out.println();
        }
        while(z != y){
            print(++z,--y,n);
            System.out.println();
        }


    }
    public static void print(int z, int y, int n){
        for (int i = 0; i < 2*n -1;i++){
            if(i == z || i == y){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        printStar(5);
    }
}
