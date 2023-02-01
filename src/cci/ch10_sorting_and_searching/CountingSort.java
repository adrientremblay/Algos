package ch10_sorting_and_searching;

public class CountingSort  implements SortingAlgo {
	private int n;

	// For counting sort, we must assume that the numbers are within 
	// the range 0 to n.
	public CountingSort(int n) {
		this.n = n;
	}
	
	public void sort(int[] arr) {
		// We use a temporary array tmp to store the counts, so the array is
		// not in place.
		int[] tmp = new int[n + 1];
		
		for (int i = 0 ; i < arr.length ; i++)
			tmp[arr[i]]++;

		for (int i = 1 ; i < tmp.length ; i++)
			tmp[i] += tmp[i-1];

		
		// The reason we are doing this complex shit instead of just using 
		// the array 'tmp' of counts to create a new array with the correct
		// amounts of each number in order is for the case where we are sorting
		// objects by some number.
		for (int i = 0 ; i < arr.length ; i++) {
			int num = arr[i];
			arr[--tmp[num]] = num;
		}
	}
	
	public static void main(String args[]) {
		int[] testArr = {1,7,4,3,7,5,4,6,4,3,7,5,4,2,1,6,5,4};
		
		CountingSort countingSort = new CountingSort(9);
		countingSort.sort(testArr);
		
		for (int num : testArr)
			System.out.print(num);
	}
}
