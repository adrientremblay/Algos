package clrs.ch14_dynamic_programming;

import java.util.HashMap;

public class RodCuttingProblem {
	public int naiveSolution(int prices[], int length) {
		if (length == 0)
			return 0;
		
		int ret = Integer.MIN_VALUE;
		
		for (int i = 1 ; i <= length ; i++) {
			ret = Math.max(ret, prices[i] + naiveSolution(prices, length - i));
		}
		
		return ret;
	}
	
	public int memoizedSolution(int prices[], int length) {
		HashMap<Integer, Integer> history = new HashMap<Integer, Integer>(length);
		return memoizedSolution(prices, length, history);
	}

	private int memoizedSolution(int prices[], int length, HashMap<Integer, Integer> history) {
		if (history.containsKey(length))
			return history.get(length);
		if (length == 0)
			return 0;
		
		int ret = Integer.MIN_VALUE;
		
		for (int i = 1 ; i <= length ; i++) {
			ret = Math.max(ret, prices[i] + naiveSolution(prices, length - i));
		}
		
		history.put(length, ret);
		return ret;
	}
	
	public static void main(String args[]) {
		RodCuttingProblem rcp = new RodCuttingProblem();
		
		int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		
		System.out.println(rcp.naiveSolution(prices, 4));

		System.out.println(rcp.memoizedSolution(prices, 4));
	}
}