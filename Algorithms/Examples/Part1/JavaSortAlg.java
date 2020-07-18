
package Part1;

import java.util.Arrays;

class JavaSortAlg {

	//***INSERTION SORT***
	//Best Case: O(n) comparisons, O(1) swaps [Sorted array]
	//Worst Case: O(n^2) comparisons & swaps [Reverse sorted array]
	//Avg Case: O(n^2) comparisons & swaps
	//Space: O(n) total, O(1) auxiliary
	//Adaptive, In-Place, Stable
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
	//Non-Adaptive, In-Place, Not Stable
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
	//Adaptive, In-Place, Stable
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
	//Stable
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

		int len = arr.length;
		int[] temp = new int[len];

		for (int w = 1; w < len; w *= 2) {

			for (int lo = 0; lo < len - w; lo += (2*w)) {
		
				int mid = lo + w - 1;
				int hi = Math.min(lo + 2*w - 1, len - 1);		
				bmerge(arr, temp, lo, mid, hi);
			}

		}

	}

	public static void bmerge(int[] arr, int[] temp, int lo, int mid, int hi) {
		
		for (int i = lo; i <= hi; i++) {
			temp[i] = arr[i];
		}

		int il = lo;
		int im = mid+1;

		for (int ia = lo; ia <= hi; ia++) {

			if (il > mid) {
				arr[ia] = temp[im++];
			} else if (im > hi) {
				arr[ia] = temp[il++];
			} else if (temp[il] < temp[im]) {
				arr[ia] = temp[il++];
			} else {
				arr[ia] = temp[im++];
			}

		}


	}

	//***QUICK SORT***
	//Best Case: O(nlogn) [Pivot divides array into two sublists of equivalent size] 
	//Worst Case: O(n^2) [Pivot is always either greatest or smallest element of sublist]
	//Avg Case: O(nlogn)
	//Space: O(logn) [Best case], O(n) [Worst case]
	//Not Stable
	//
	//Insertion sort is used for smaller arrays/subarrays to improve performance
	//
	public static void quickSort(int[] arr) {
		quickSortHoare(arr, 0, arr.length - 1);
	}

	public static void insortAug(int[] arr, int lo, int hi) {

		for (int k = lo+1; k < hi; k++) {

			int j = k-1;
			int val = arr[k];
			
			while (j >= 0 && arr[j] > val) {
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = val;

		}

	}

	public static void quickSortLomuto(int[] arr, int lo, int hi) {

		if (lo < hi) {

			if (hi - lo < 10) {
				insortAug(arr, lo, hi);
			} else {

				int p = lomuto(arr, lo, hi);
				quickSortLomuto(arr, lo, p-1);
				quickSortLomuto(arr, p+1, hi);
			}
		}

	}

	public static int lomuto(int[] arr, int lo, int hi) {

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

	public static void quickSortHoare(int[] arr, int lo, int hi) {

		if (lo < hi) {

			if (hi - lo < 10) {
				insortAug(arr, lo, hi);
			} else {

				int p = hoare(arr, lo, hi);
				quickSortHoare(arr, lo, p);
				quickSortHoare(arr, p+1, hi);
			}
		}

	}
	
	//Bidirectional iteration through subarray reduces the number of swaps vs Lomuto
	//Ex: Hoare is faster if the leftmost element is the largest in the subarray as Lomuto
	//    would behave like bubblesort
	public static int hoare(int[] arr, int lo, int hi) {

		int pivot = arr[(hi+lo)/2];
		int k = lo - 1;
		int j = hi + 1;

		while (true) {

			do {
				k++;
			} while (arr[k] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (k >= j)
				return j;

			int temp = arr[k];
			arr[k] = arr[j];
			arr[j] = temp;
			

		}

	}

	//Quicksort with three way partition
	//Efficient for arrays with many repeated values, based on Dutch national flag problem
	public static void quickSortDutch(int[] arr, int lo, int hi) {

		if (lo < hi) {

			int lt = lo;
			int gt = hi;
			int i = lo;

			while (i <= gt) {

				if (arr[i] < arr[lt]) swap(arr, i++, lt++);
				else if (arr[i] > arr[lt]) swap(arr, i, gt--);
				else i++;	

			}

			quickSortDutch(arr, lo, lt-1);
			quickSortDutch(arr, gt+1, hi);

		}

	}

	//Testing methods
	public static void main(String[] args) {

		int[] a = {4,6,2,3,8,7,3,1,9,8,6,1,10};
		int[] b = {3,4,6,3,4,4,6,7,9,8,5,4,4,2,1,3,4,4,6,5,4,8,9,10,12,4};		
		quickSort(a);
		quickSortDutch(b, 0, b.length-1);		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

}

