
package Strategy;

public class Sorter {

	private IStrategy sortStrat;

	public Sorter(IStrategy sortStrat) {
		this.sortStrat = sortStrat;
	}

	public void setStrat(IStrategy sortStrat) {
		this.sortStrat = sortStrat;
	}

	public void testAlg(int[] arr) {

		int[] copy = arr.clone();
		
		long start = System.currentTimeMillis();
		sortStrat.sort(copy);
		long end = System.currentTimeMillis();

		System.out.println("The sorting time for " + sortStrat.getName() + " is " + (end - start) + " ms");

	}

}

