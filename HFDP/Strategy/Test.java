
package Strategy;

import java.util.Random;

public class Test {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100) + 1;
		}

		IStrategy insort = new InsortStrategy();
		IStrategy binsort = new BinaryInsortStrategy();
		IStrategy bubble = new BubbleStrategy();
		IStrategy lomuto = new QuickLomutoStrategy();
		IStrategy hoare = new QuickHoareStrategy();
		
		Sorter sorter = new Sorter(insort);
		sorter.testAlg(arr);
		sorter.setStrat(binsort);
		sorter.testAlg(arr);
		sorter.setStrat(bubble);
		sorter.testAlg(arr);
		sorter.setStrat(lomuto);
		sorter.testAlg(arr);
		sorter.setStrat(hoare);
		sorter.testAlg(arr);

	}

}

