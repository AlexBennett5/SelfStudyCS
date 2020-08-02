
package Strategy;

public class BubbleStrategy implements IStrategy {

	public void sort(int[] arr) {

		boolean check = true;

		while (check) {
			check = false;

			for (int k = 0; k < arr.length-1; k++) {
				if (arr[k] > arr[k+1]) {
					swap(arr, k, k+1);
					check = true;
				}
			}
			
		}

	}

	public void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	public String getName() {
		return "Bubblesort";
	}

}

