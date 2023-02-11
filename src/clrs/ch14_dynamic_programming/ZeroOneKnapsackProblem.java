package clrs.ch14_dynamic_programming;

public class ZeroOneKnapsackProblem {
	public static int tableSolution(int[] values, int[] weights, int sackSize) throws Exception {
		int n = values.length;
		
		int[][] table = new int[n + 1][sackSize + 1];
		
		for (int i = 1 ; i < table.length ; i++) {
			for (int j = 1 ; j < table[j].length ; j++) {
				if (j < weights[i-1]) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i-1][j - weights[i-1]] + values[i-1]);
				}
			}
		}
		
		return -1;
	}
}
