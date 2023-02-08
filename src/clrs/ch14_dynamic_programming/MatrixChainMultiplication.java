package clrs.ch14_dynamic_programming;

public class MatrixChainMultiplication {
	public static int naiveTopDownSolution(int[][] matrices, int i, int j) {
		if (i == j)
			return 0;
		
		if (i + 1 == j)
			return matrices[i][0] * matrices[i][1] * matrices[j][1];
		
		int best = Integer.MAX_VALUE;
		for (int k = i ; k <= j-1 ; k++) {
			best = Math.min(best, naiveTopDownSolution(matrices, i, k) 
					+ naiveTopDownSolution(matrices, k+1, j) 
					+ (matrices[i][0] * matrices[k][1] * matrices[j][1]));
		}
		return best;
	}
	
	
	public static void main(String args[]) {
		int[][] sampleMatrices = {
			{10, 20},
			{20, 30},
			{30, 5},
			{5, 20},
			{20, 10}
		};
		
		int ans = naiveTopDownSolution(sampleMatrices, 0, 4);
		System.out.println(ans);
	}

}