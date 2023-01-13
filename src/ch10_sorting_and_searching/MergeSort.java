package ch10_sorting_and_searching;

public class MergeSort {
	public MergeSort() {
		
	}
	
	public void sort(int[] arr) {
		mergesort(arr, 0, arr.length-1);
	}
	
	private void mergesort(int[] arr, int start, int end) {
		if (start + 1 == end) {
			if (arr[start] > arr[end]) {
				int tmp = arr[end];
				arr[end] = arr[start];
				arr[start] = tmp;
			}
			return;
		}

		int mid = (start + end) / 2;
		mergesort(arr, start, mid);
		mergesort(arr, mid+1, end);
		merge(arr, start, mid+1 , end);
	}
	
	private void merge(int[] arr, int start , int mid, int end) {
		int i1 = start;
		int i2 = mid;
		int i = 0;
		
		int[] tempArr = new int[end - start + 1];
		
		while (i1 < mid && i2 <= end) {
			if (arr[i1] < arr[i2]) {
				tempArr[i++] = arr[i1++];
			} else {
				tempArr[i++] = arr[i2++];
			}
		}
		while (i1 < mid) {
			tempArr[i++] = arr[i1++];
		}
		while (i2 <= end) {
			tempArr[i++] = arr[i2++];
		}
		
		i1 = start;
		for (i = 0 ; i < tempArr.length ; i++) {
			arr[i1++] = tempArr[i];
		}
	}
	
	public static void main(String args[]) {
		int[] testArr = {6,3,6,5};
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(testArr);
		
		for (int num : testArr)
			System.out.print(num + " ");
	}
}
