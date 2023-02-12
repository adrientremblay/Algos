package clrs.ch14_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class ZeroOneKnapsackProblem {
	public static List<Integer> tableSolution(int[] values, int[] weights, int sackSize) throws Exception {
		int[][] table = new int[values.length + 1][sackSize + 1];
		
		// Finding the max value given the sack size
		for (int i = 1 ; i < table.length ; i++) {
			for (int j = 1 ; j < table[i].length ; j++) {
				if (j < weights[i-1]) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i-1][j - weights[i-1]] + values[i-1]);
				}
			}
		}
		
		Util.printMatrix(table);
		
		// Reconstructing the solution
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int i = table.length - 1;
		int j = table[i].length - 1;

		while (i > 0 && j > 0) {
			if (table[i-1][j] != table[i][j]) {
				ans.add(i-1);
				j -= weights[i-1];
			} 
			i--;
		}
		
		return ans;
	}
	
	public static void main(String args[]) throws Exception {
		int[] testValues = {2, 2, 4, 5, 3};
		int[] testWeights = {3, 1, 3, 4, 2};
		int capacity = 7;
		
		List<Integer> answer = tableSolution(testValues, testWeights, capacity);
		for (Integer i : answer) {
			System.out.println("Weight : " + testWeights[i]);
			System.out.println("Value : " + testValues[i]);
			System.out.println();
		}
		System.out.println(answer);
	}
}
