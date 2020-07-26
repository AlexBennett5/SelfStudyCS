
package Tick1;

import java.util.Arrays;

public class MaxCharHeap implements MaxCharHeapInterface {

	private char[] heap;

	public MaxCharHeap(char[] x) {

		heap = new char[x.length];

		for (int i = 0; i < x.length; i++) {
			heap[i] = x[i];
		}

		heapify();
	}

	public void heapify() {

		int n = getLength();

		for (int k = n/2; k >= 0; k--) {
			maxHeapify(k);
		}

	}

	public void maxHeapify(int ind) {

		int n = getLength();
		int l = 2*ind + 1;
		int r = 2*ind + 2;
		int largest = ind;

		if (l < n && heap[l] > heap[ind]) largest = l;
		if (r < n && heap[r] > heap[largest]) largest = r;

		if (largest != ind) {
			swap(largest, ind);
			maxHeapify(largest);
		}

	}

	public void swap(int j, int k) {
		char temp = heap[j];
		heap[j] = heap[k];
		heap[k] = temp;
	}

	public void insert(char e) {
	
		int n = getLength();
		char[] newarr = new char[n + 1];

		for (int i = 0; i < n; i++) {
			newarr[i] = heap[i];
		}
		newarr[n] = e;
		heap = newarr;

		heapify();
	}

	public char popMax() throws EmptyHeapException {

		if (getLength() < 1) {
			throw new EmptyHeapException();
		}

		char head = heap[0];
		int n = getLength();
		char[] newarr = new char[n-1];
		
		for (int i = 1; i < n; i++) {
			newarr[i-1] = heap[i];
		}

		heap = newarr;
		heapify();
		return head;

	}

	public int getLength() {
		return heap.length;
	}

	public void print() {
		System.out.println(Arrays.toString(heap));
	}

	public static void main(String[] args) {

		char[] arr = {'a', 'f', 'e', 'c', '?', '^', '%', '1', 'b', '9'};
		MaxCharHeap test = new MaxCharHeap(arr);
		test.print();
		test.insert(' ');
		test.insert('q');
		test.print();
		try{
			System.out.println(test.popMax());
		} catch (EmptyHeapException e) {
			System.out.println("Heap is empty");
		}
		test.print();

	}

}

