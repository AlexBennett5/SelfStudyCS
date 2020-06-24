
package ab.practice.tick3;

public class FibonacciCache {

	public static long[] fib = new long[20];

	public static void store() {

		if (fib.length == 0)
			return;

		for (int i = 0; i < fib.length; i++) {
			
			if (i == 0) {
				fib[i] = 1L;
			} else if (i == 1) {
				fib[i] = 1L;
			} else {
				fib[i] = fib[i-1] + fib[i-2];
			}

		}

	}

	public static void reset() {

		for (int i = 0; i < fib.length; i++) {
			fib[i] = 0L;
		}

	}

	public static long get(int i) {

		if (i < 0 || i > fib.length)
			return -1L;

		return fib[i];
	}

	public static void main(String[] args) {

		store();
		System.out.println(get(18));
		reset();
		System.out.println(get(18));

	}

}


