package matrix;

public class PrintMatrixSpiralOrder {
    /*
    转圈打印矩阵
     */
    public static void printMatrixSpiralOrder(int[][] arr){
        int tR = 0;
        int tC = 0;
        int dR = arr.length - 1;
        int dC = arr[0].length - 1;
        while(tR <= dR && tC <= dC){
            printMatrixSpiralOrder(arr, tR++, tC++, dR--, dC--);
        }
    }
    private static void printMatrixSpiralOrder(int[][] arr, int tR, int tC, int dR, int dC) {
        if(tR == dR){
            while (tC <= dC){
                System.out.print(arr[tR][tC++] + " ");
            }
        }else if (tC == dC){
            while (tR <= dR){
                System.out.print(arr[tR++][tC] + " ");
            }
        }else{
            for(int i = tC; i < dC;i++){
                System.out.print(arr[tR][i] + " ");
            }
            for(int i = tR; i < dR; i++){
                System.out.print(arr[i][dC] + " ");
            }
            for(int i = dC; i > tC; i--){
                System.out.print(arr[dR][i] + " ");
            }
            for (int i = dR; i > tR; i--){
                System.out.print(arr[i][tC] + " ");
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };;
        printMatrix(matrix);
        System.out.println("========");
        printMatrixSpiralOrder(matrix);
    }
}
