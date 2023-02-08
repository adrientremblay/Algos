package cci.ch1_arrays_and_strings;

public class RotateMatrix {
    public int[][] inPlace(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0 ; i <= (n - 1) / 2 ; i++) {
            for (int j = i ; j <= (n - 1) / 2 ; j++) {
                int row = i;
                int col = j;
                int hold = matrix[row][col];
                for (int count = 1 ; count <= 4 ; count++) {
                    int newRow = col;
                    int newCol = n - 1 - row;
                    int tmp = matrix[newRow][newCol];
                    matrix[newRow][newCol] = hold;
                    hold = tmp;
                    row = newRow;
                    col = newCol;
                }
            }
        }

        return matrix;
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
        RotateMatrix rotateMatrix = new RotateMatrix();

        int[][] testMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] testMatrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotateMatrix.printMatrix(rotateMatrix.inPlace(testMatrix));
        rotateMatrix.printMatrix(rotateMatrix.inPlace(testMatrix2));
    }
}
