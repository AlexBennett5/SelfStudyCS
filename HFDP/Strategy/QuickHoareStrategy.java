
package Strategy;

public class QuickHoareStrategy implements IStrategy {

	public void sort(int[] arr) {
		quickSortHoare(arr, 0, arr.length-1);
	}

	public void quickSortHoare(int[] arr, int lo, int hi) {

		if (lo < hi) {
			int p = hoare(arr, lo, hi);
			quickSortHoare(arr, lo, p);
			quickSortHoare(arr, p+1, hi);
		}

	}

	public int hoare(int[] arr, int lo, int hi) {

		int pivot = arr[(hi+lo)/2];
		int k = lo - 1;
		int j = hi + 1;

		while (true) {

			do {
				k++;
			} while (arr[k] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (k >= j)
				return j;

			swap(arr, k, j);

		}

	}

	public void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	public String getName() {
		return "Quicksort (Hoare)";
	}

}

