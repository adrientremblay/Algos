package src.clrs.ch14_dynamic_programming;

import src.util.Util;

/**
 * Find the minimal amount of coins of different specified values to reach a specified total value
 */
public class CoinSelectionProblem {
    public static int dpSolution(int values[], int total) {
        int[][] m = new int[values.length][total + 1];

        for (int i = 0 ; i < m.length ; i++) {
            for (int j = 1 ; j < m[i].length ; j++) {
                if (i == 0) {
                    m[i][j] = (j % values[i] == 0) ? (j / values[i]) : (-1);
                } else if (j < values[i]){
                    m[i][j] = m[i-1][j];
                } else if (m[i-1][j] == -1) {
                    m[i][j] = m[i][j-values[i]] + 1;
                } else {
                    m[i][j] = Math.min(m[i-1][j], m[i][j-values[i]] + 1);
                }
            }
        }

        Util.printMatrix(m);

        return m[values.length - 1][total];
    }

    public static int dpSolutionMustHave1(int values[], int total) {
        int[][] m = new int[values.length][total + 1];

        for (int i = 0 ; i < m.length ; i++) {
            for (int j = 1 ; j < m[i].length ; j++) {
                if (i == 0) { // values[0] must be 1 for this algo
                    m[i][j] = j;
                } else if (j < values[i]){
                    m[i][j] = m[i-1][j];
                } else {
                    m[i][j] = Math.min(m[i-1][j], m[i][j-values[i]] + 1);
                }
            }
        }

        Util.printMatrix(m);

        return m[values.length - 1][total];
    }

    public static void main(String args[]) {
        int[] values = {1, 5, 6, 8};
        int target = 11;

        dpSolutionMustHave1(values, target);

        int[] values2 = {2, 5, 6, 8};
        int target2 = 11;

        dpSolutionMustHave1(values2, target2);
    }
}
