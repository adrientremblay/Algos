package ch10_sorting_and_searching;

public class SelectionSort {
	public SelectionSort() {
		
	}
	
	public void sort(int[] arr) {
		for (int i = 0 ; i < arr.length ; i++) {
			int smallestJ = i;
			for (int j = i+1 ; j < arr.length ; j++)
				if (arr[j] < arr[smallestJ])
					smallestJ = j;
			int tmp = arr[i];
			arr[i] = arr[smallestJ];
			arr[smallestJ] = tmp;
		}
	}
	
	public static void main(String args[]) {
		int[] testArr = {5,3,6,4,2,1,1,4,6,7,4,3,1,2,4,6,012,392,3,12};
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(testArr);
		for (int num : testArr)
			System.out.print(num + " ");
	}
}
