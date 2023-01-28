package ch10_sorting_and_searching;

public class QuickSort  implements SortingAlgo {
	public QuickSort() {
		
	}
	
	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		
		int pivot = (left + right) / 2;
		int searchLeft = left;
		int searchRight = right;
		
		while (searchLeft < searchRight) {
			while (searchLeft < searchRight && arr[searchLeft] < arr[pivot])
				searchLeft++;
			while (searchRight > searchLeft && arr[searchRight] > arr[pivot])
				searchRight--;
			int tmp = arr[searchRight];
			arr[searchRight] = arr[searchLeft];
			arr[searchLeft] = tmp;
			searchLeft++;
			searchRight--;
		}
		
		quickSort(arr, left, searchLeft-1);
		quickSort(arr, searchLeft, right);
	}
	
	public static void main(String[] args) {
		int[] testArr = {5,4,6,3,1,2,6,8,9,67,5,3,78,2,7,};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(testArr);

		for (int num : testArr)
			System.out.print(num + " ");
	}
}
