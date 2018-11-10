package matrix;

public class ZigZagPrintMatrix {
    /*
    “之”字形打印矩阵
     */
    public static void printMatrixZigZag(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        boolean flag = true;
        //列的界限
        int endR = matrix.length - 1;
        //行的界限
         int endC = matrix[0].length - 1;
        while (tR != endR + 1) {
            printMatrixZigZag(matrix,tR,tC,dR,dC,flag);
            //对界限的处理
            if(tC == endC){
                tR++;
            }else {
                tC++;
            }
            if (dR == endR){
                dC++;
            }else {
                dR++;
            }
            flag = !flag;
            System.out.println();
        }
    }

    private static void printMatrixZigZag(int[][] matrix, int tR, int tC, int dR, int dC, boolean flag) {
        if(flag){
            while(dC <= tC)
            System.out.print(matrix[dR--][dC++] + " ");
        }else {
            while (tC >= dC)
            System.out.print(matrix[tR++][tC--] + " ");
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
        int[][] matrix = { { 1, 2, 3, 4 ,11,}, { 5, 6, 7, 8,15 }, { 9, 10, 11, 12 ,17} };
        printMatrix(matrix);
        System.out.println("=================");
        printMatrixZigZag(matrix);

    }
}
