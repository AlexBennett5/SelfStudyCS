import java.util.Arrays;

public class javatest {

	public static void main(String args[]) {

		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		float[][] arr = zeroarr(n,m);
	        float[][] transpose = transp(arr);	

		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(transpose));

	}

	public static int factorial(int n, int a) {

		if (n < 2) {
			return a;
		}

		return fact2(n-1, a*n);

	}

	public static int fact2(int n, int a) {

		if (n < 2) {
			return a;
		}

		return factorial(n-1, a*n);
	}

	public static int lowestCommon(long n, long m) {

		long num = n & m;
		int i = 1;

		while (i < 65) {

			boolean x = lsb(num, i);

			if (x) {
				break;
			}

			i++;

		}

		if (i > 64) {
			return -1;
		}

		return i-1;
	}	

	public static boolean lsb(long n, int k) {

		boolean x = (n & (1 << (k-1))) != 0;

		return x;

	}

	public static float[][] zeroarr(int n, int m) {

		float[][] arr = new float[n][m];
		int i = 0;

		while (i < n) {
			
			int j = 0;

			while (j < m) {

				arr[i][j] = 0;
				j++;
			}

			i++;
		}

		return arr;
	}

	public static float[][] transp(float[][] arr) {

		int n = arr.length;
		int m = arr[0].length;

		float[][] res = new float[m][n];

		int j = 0;

		while (j < m) {

			int i = 0;

			while (i < n) {

				res[j][i] = arr[i][j];
				i++;
			}

			j++;
		}

		return res;
	}
		

}

