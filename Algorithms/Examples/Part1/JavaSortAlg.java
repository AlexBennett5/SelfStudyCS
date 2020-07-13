
package Part1;

import java.util.Arrays;

class JavaSortAlg {

	//***INSERTION SORT***
	//Best Case: O(n) comparisons, O(1) swaps [Sorted array]
	//Worst Case: O(n^2) comparisons & swaps [Reverse sorted array]
	//Avg Case: O(n^2) comparisons & swaps
	//Space: O(n) total, O(1) auxiliary
	//Adaptive, In-Place
	//
	//More efficient than Selection Sort when array is partially sorted
	//
	public static void insort(int[] arr) {

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

	//***BINARY INSERTION SORT ***
	//Same complexity as Insertion Sort, marginal improvement on comparisons
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

	//***SELECTION SORT***
	//Best Case: O(n^2) comparisons, O(1) swaps
	//Worst Case: O(n^2) comparions, O(n) swaps
	//Avg Case: O(n^2) comparisons, O(n) swaps
	//Space: O(n) total, O(1) auxiliary
	//Non-Adaptive, In-Place
	//
	//Less writes (swaps) than insertionsort (O(n) vs O(n^2))
	//
	public static void selectSort(int[] arr) {

		for (int k = 0; k < arr.length; k++) {

			int mindex = k;

			for (int j = k+1; j < arr.length; j++) {
			
				if (arr[j] < arr[mindex]) {
					mindex = j;
				}
			}
		
			if (mindex != k) {
				swap(arr, mindex, k);
			}
		}

	}

	//Auxiliary swap function
	public static void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	//***BUBBLE SORT***
	//Best Case: O(n) comparisons, O(1) swaps [Sorted array]
	//Worst Case: O(n^2) comparisons & swaps [Reverse sorted array]
	//Avg Case: O(n^2) comparisons & swaps
	//Space: O(n) total, O(1) auxiliary
	//Adaptive, In-Place
	//
	//Noticeably slower than Insertion Sort despite same Big-O
	//During a pass Insertion Sort can bail early, Bubble Sort must see it to the end
	//
	public static void bubbleSort(int[] arr) {

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

	//***TOP-DOWN MERGE SORT***
	//Best Case: O(nlogn)
	//Worst Case: O(nlogn)
	//Avg Case: O(nlogn)
	//Space: O(n) total, O(n) auxiliary
	//
	public static int[] mergeSort(int[] arr) {

		if (arr.length < 2) { return arr; }

		int mid = arr.length/2;
		int[] l = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] r = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(l, r, arr.length);

	}

	public static int[] merge(int[] l, int[] r, int size) {

		int[] res = new int[size];
		int i = 0;
		int il = 0;
		int ir = 0;

		while (il < l.length || ir < r.length) {
			
			if (il >= l.length) {
				res[i++] = r[ir++];
			} else if (ir >= r.length) {
				res[i++] = l[il++];
			} else if (l[il] < r[ir]) {
				res[i++] = l[il++];
			} else {
				res[i++] = r[ir++];
			}
		}

		return res;

	}
	
	//***BOTTOM-UP MERGESORT***
	//Non-recursive implementation of mergesort
	//
	public static void bmergeSort(int[] arr) {
	
	
		int[] temp = new int[arr.length];

		//w is one half the width of subarray being considered
		for (int w = 1; w < arr.length; w *= 2) {

			for (int lo = 0; lo < arr.length-w; lo += 2*w) {

				int mid = lo + w - 1;
				int hi = Math.min(lo + 2*w - 1, arr.length - 1);
				bmerge(arr, temp, lo, mid, hi);
			}
		}


	}

	public static void bmerge(int[] arr, int[] temp, int lo, int mid, int hi) {

		//Copy original array values to temp
		for (int i = lo; i <= hi; i++) {
			temp[i] = arr[i];
		}
		
		int il = lo;
		int ir = mid+1;

		for (int i = lo; i <= hi; i++) {

			if (il > mid) {
				arr[i] = temp[ir++];
			} else if (ir > hi) {
				arr[i] = temp[il++];
			} else if (temp[il] < temp[ir]) {
				arr[i] = temp[il++];
			} else {
				arr[i] = temp[ir++];
			}

		}


	}


	//Testing methods
	public static void main(String[] args) {

		int[] a = {4,6,2,3,8,7,3,1,9,8,6,1,10};		
		bmergeSort(a);		
		System.out.println(Arrays.toString(a));
	}

}

