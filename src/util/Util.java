package src.util;

public class Util {
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }
}
