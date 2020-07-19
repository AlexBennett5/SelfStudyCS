
package Part1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class JavaSortAlg {

	//***COMPARISON SORTS***

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
	//
	//arr[lo..lt-1] < mid = arr[lt..gt] < arr[gt+1..hi]
	//mid is arr[lo] by default
	//
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

	//***HEAP SORT***
	//Best Case: O(nlogn)
	//Worst Case: O(nlogn)
	//Avg Case: O(nlogn)
	//Space: O(n) total, O(1) auxiliary
	//In-Place, Not Stable
	//
	//In the best case slower than Quicksort since it must always swap 100% of elements
	//In the worst case faster than Quicksort
	//
	public static void heapSort(int[] arr) {
		maxHeapSort(arr);
	}

	//Heap Sort using a max heap (sorts to ascending order)
	public static void maxHeapSort(int[] arr) {

		for (int k = arr.length/2 - 1; k >= 0; k--) {
			maxHeapify(arr, arr.length, k);
		}

		for (int k = arr.length-1; k > 0; k--) {
			swap(arr, 0, k);
			maxHeapify(arr, k, 0);
		}

	}

	public static void maxHeapify(int[] arr, int end, int root) {

		int l = 2*root + 1;
		int r = 2*root + 2;

		int largest = root;

		if (l < end && arr[l] > arr[root]) largest = l;
		if (r < end && arr[r] > arr[largest]) largest = r;

		if (largest != root) {
			swap(arr, root, largest);
			maxHeapify(arr, end, largest);
		}

	}

	//Heap Sort using a min heap (sorts to descending order)
	public static void minHeapSort(int[] arr) {

		for (int k = arr.length/2 - 1; k >= 0; k--) {
			minHeapify(arr, arr.length, k);
		} 

		for (int k = arr.length-1; k > 0; k--) {
			swap(arr, 0, k);
			minHeapify(arr, k, 0);
		}

	}

	public static void minHeapify(int[] arr, int end, int root) {

		int l = 2*root + 1;
		int r = 2*root + 2;

		int smallest = root;

		if (l < end && arr[l] < arr[root]) smallest = l;
		if (r < end && arr[r] < arr[smallest]) smallest = r;

		if (smallest != root) {
			swap(arr, root, smallest);
			minHeapify(arr, end, smallest);
		}

	}

	//***LINEAR SORTS***

	//***COUNTING SORT***
	// Best/Worst/Avg Case: O(n+k) [k is possible values within assumed range]
	// Space: O(k) auxiliary
	//
	//Assumption: Input is array of small integers.
	//Variation in key values should not be much greater than length of array
	//
	public static void countSort(int[] arr) {

		int n = arr.length;
		int[] count = new int[n];

		for (int k = 0; k < n; k++) {
			count[k] = 0;
		}

		for (int k = 0; k < n; k++) {
			count[arr[k]]++;
		}

		int k = 0;
		int j = 0;

		while (j < n) {
	
			if (count[j] == 0) {
				j++;
			} else {
				arr[k++] = j;
				count[j]--;
			}
	
		}

	}

	//***BUCKET SORT***
	//Best Case: O(n+k) [k is number of buckets]
	//Worst Case: O(n^2) [all elements allocated to same bucket]
	//Avg Case: O(n+k)
	//Space: O(n+k) auxiliary
	//
	//Assumption: Elements are uniformly distributed among buckets
	//The average bucket should contain ~O(1) elements
	//If concentrated to one bucket, the complexity is that of the auxiliary sorting alg
	//
	public static void bucketSort(float[] arr) {

		int n = arr.length;

		if (n <= 0) return;
		
		ArrayList<Float>[] bucket = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			bucket[i] = new ArrayList<Float>();
		}

		for (int i = 0; i < n; i++) {
			int index = (int) arr[i] * n;
			bucket[index].add(arr[i]);
		}

		for (int i = 0; i < n; i++) {
			Collections.sort(bucket[i]);
		}

		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0, len = bucket[i].size(); j < len; j++) {
				arr[index++] = bucket[i].get(j);
			}
		}

	}

	//***RADIX SORT***
	//Worst Case: O(w*n) [w is number of digits to store each key]
	//Space: O(w+n)
	//
	//Assumption: Only works when sorting numbers with fixed number of digits
	//Arbitrarily large integers don't work
	//
	public static void radixSort(int[] arr) {
		
		final int radix = 10;
		ArrayList<Integer>[] bucket = new ArrayList[radix];

		for (int i = 0; i < radix; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		boolean maxLength = false;
		int place = 1;
		int val = -1;

		while(!maxLength) {

			maxLength = true;

			//Count sort on place value
			for (Integer i : arr) {

				val = i/place;
				bucket[val % radix].add(i);

				if (maxLength && val > 0) {
					maxLength = false;
				}
			}

			int k = 0;

			for (int j = 0; j < radix; j++) {
				for (Integer i : bucket[j]) {
					arr[k++] = i;
				}
				bucket[j].clear();
			}

			place *= radix;
		
		}

	}

	//Testing methods
	public static void main(String[] args) {

		int[] a = {434,2342,6234,123,347,872,109,107,23,1,245};	
		float[] b = {(float)0.23, (float)0.56, (float)0.12, (float)0.333, (float)0.81, (float)0.999};
		radixSort(a);
		bucketSort(b);
		System.out.println(Arrays.toString(a));	
		System.out.println(Arrays.toString(b));

	}

}

