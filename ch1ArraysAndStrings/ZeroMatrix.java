package ch1ArraysAndStrings;

public class ZeroMatrix {
    public void mySolution(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // determining which rows and cols to zero
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // doing the actual zeroing
        for (int row = 0 ; row < rows.length ; row++) {
            if (!rows[row])
                continue;

            for (int j = 0 ; j < n ; j++)
                matrix[row][j] = 0;
        }

        for (int col = 0 ; col < cols.length ; col++) {
            if (!cols[col])
                continue;

            for (int i = 0 ; i < m ; i++)
                matrix[i][col] = 0;
        }
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] testMatrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 0}
        };

        int[][] testMatrix2 = {
                {0, 2, 3, 4},
                {0, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0},
                {13, 14, 15, 16}
        };

        ZeroMatrix zeroMatrix = new ZeroMatrix();
        zeroMatrix.mySolution(testMatrix);
        zeroMatrix.mySolution(testMatrix2);

        zeroMatrix.printMatrix(testMatrix);
        zeroMatrix.printMatrix(testMatrix2);

    }
}
