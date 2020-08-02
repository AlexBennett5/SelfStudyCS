
package Strategy;

public class QuickLomutoStrategy implements IStrategy {

	public void sort(int[] arr) {
		quickSortLomuto(arr, 0, arr.length-1);
	}

	public void quickSortLomuto(int[] arr, int lo, int hi) {

		if (lo < hi) {

			int p = lomuto(arr, lo, hi);
			quickSortLomuto(arr, lo, p-1);
			quickSortLomuto(arr, p+1, hi);
		}	

	}

	public int lomuto(int[] arr, int lo, int hi) {

		int pivot = arr[hi];
		int k = lo;

		for (int j = lo; j < hi; j++) {

			if (arr[j] < pivot) {
				swap(arr, k, j);
				k++;
			}
		}

		swap(arr, k, hi);
		return k;
	}

	public void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	public String getName() {
		return "Quicksort (Lomuto)";
	}

}

