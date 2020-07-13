
package Part1;

import java.util.Arrays;

class JavaAlgTest {

	//InsertionSort where comparisons are handled with binary search
	public static void binaryInsort(int[] arr) {

		for (int k = 1; k < arr.length; k++) {

			int lo = 0, hi = k;

			// Binary search to find index of insertion
			while (lo < hi) {
				int mid = lo + (hi-lo)/2;

				if (arr[k] < arr[mid]) hi = mid;
				else lo = mid+1;
			}

			if (lo != k) {
				int temp = arr[k];

				// Shift arr[lo], ..., arr[k-1] to the right
				for (int j = k-1; j > lo-1; j--) {
					arr[j+1] = arr[j];
				}

				arr[lo] = temp;
			}

		}

	}

	public static void main(String[] args) {

		int[] a = {4,6,2,3,8,7,3,1,9,8,6,1,10};
		binaryInsort(a);
		System.out.println(Arrays.toString(a));

	}

}

