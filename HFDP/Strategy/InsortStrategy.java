
package Strategy;

public class InsortStrategy implements IStrategy {

	public void sort(int[] arr) {

		for (int k = 1; k < arr.length; k++) {

			int j = k-1;
			int val = arr[k];
			
			while (j >= 0 && arr[j] > val) {
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = val;

		}

	}

	public String getName() {
		return "Insort";
	}

}

