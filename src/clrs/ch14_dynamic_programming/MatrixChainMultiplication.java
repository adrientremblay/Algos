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

	public static int naiveTopDownSolutionExtended(int[][] matrices, int i, int j, int[][] parenthesisLocations) {
		if (i == j)
			return 0;
		
		if (i + 1 == j)
			return matrices[i][0] * matrices[i][1] * matrices[j][1];
		
		int best = Integer.MAX_VALUE;
		for (int k = i ; k <= j-1 ; k++) {
			int cost = naiveTopDownSolution(matrices, i, k) 
					+ naiveTopDownSolution(matrices, k+1, j) 
					+ (matrices[i][0] * matrices[k][1] * matrices[j][1]);
			if (cost < best) {
				best = cost;
				parenthesisLocations[i][j] = k;
			}
		}
		return best;
	}

	public static int memoizedTopDownSolutionExtended(int[][] matrices, int i, int j, int[][] history, int[][] parenthesisLocations) {
		if (i == j)
			return 0;
		
		if (i + 1 == j)
			return matrices[i][0] * matrices[i][1] * matrices[j][1];
		
		if (history[i][j] != 0)
			return history[i][j];
		
		int best = Integer.MAX_VALUE;
		for (int k = i ; k <= j-1 ; k++) {
			int cost = naiveTopDownSolution(matrices, i, k) 
					+ naiveTopDownSolution(matrices, k+1, j) 
					+ (matrices[i][0] * matrices[k][1] * matrices[j][1]);
			if (cost < best){
				best = cost;
				parenthesisLocations[i][j] = k;
			}
		}
		history[i][j] = best;
		return best;
	}
	
	public static void printParenthesisLocations(int[][] parenthesisLocations, int i , int j) {
		if (i == j) {
			System.out.print("A" + (i+1));
			return;
		}

		if (i + 1 == j) {
			System.out.print("(A" + (i+1));
			System.out.print("A" + (j+1) + ")");
			return;
		}
		
		System.out.print('(');
		int k = parenthesisLocations[i][j];
		printParenthesisLocations(parenthesisLocations,i, k);
		printParenthesisLocations(parenthesisLocations,k+1, j);
		System.out.print(')');
	}
	
	
	public static void main(String args[]) {
		int[][] sampleMatrices = {
			{10, 20},
			{20, 30},
			{30, 5},
			{5, 20},
			{20, 10}
		};
		
		int[][] history = new int[5][5];
		int[][] parenthesisLocations = new int[5][5];
		
		int ans = memoizedTopDownSolutionExtended(sampleMatrices, 0, 4, history, parenthesisLocations);
		System.out.println(ans);
		
		printParenthesisLocations(parenthesisLocations, 0, 4);
	}

}