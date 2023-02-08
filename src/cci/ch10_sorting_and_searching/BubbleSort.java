package cci.ch10_sorting_and_searching;

public class BubbleSort implements SortingAlgo {
	public BubbleSort() {
		
	}
	
	public void sort(int[] arr) {
		boolean bubbleArrAgain = true;
		
		while (bubbleArrAgain) {
			bubbleArrAgain = false;
			for (int i = 1 ; i < arr.length ; i++) {
				if (arr[i-1] > arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = tmp;
					bubbleArrAgain = true;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		int[] testArr = {4,6,3,1,4,6,7,5,4,2,1,3,4,7,4,199,3,69,420,33,15};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(testArr);
		for(int num : testArr) {
			System.out.print(num + " ");
		}
	}

}
