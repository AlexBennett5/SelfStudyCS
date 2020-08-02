
package Strategy;

public class BinaryInsortStrategy implements IStrategy {

	public void sort(int[] arr) {

		for (int k = 1; k < arr.length; k++) {

			int lo = 0, hi = k;

			while (lo < hi) {
				int mid = lo + (hi-lo)/2;

				if (arr[k] < arr[mid]) hi = mid;
				else lo = mid+1;
			}

			if (lo != k) {
				int temp = arr[k];

				for (int j = k-1; j > lo-1; j--) {
					arr[j+1] = arr[j];
				}

				arr[lo] = temp;
			}

		}

	}

	public String getName() {
		return "Binary Insort";
	}

}

