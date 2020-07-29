
package Tick1Star;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Comparable;

public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private ArrayList<T> heap;

	public MaxHeap(List<T> x) {
		
		heap = new ArrayList<T>();
		for (T obj : x) {
			heap.add(obj);
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

		if (l < n && heap.get(l).compareTo(heap.get(largest)) == 1)  largest = l;
		if (r < n && heap.get(r).compareTo(heap.get(largest)) == 1) largest = r;

		if (largest != ind) {
			swap(largest, ind);
			maxHeapify(largest);
		}

	}

	public void swap(int j, int k) {
		
		T temp = heap.get(j);
		heap.set(j, heap.get(k));
		heap.set(k, temp);

	}

	public void insert(T e) {
		
		heap.add(e);	
		heapify();
	}

	public T popMax() throws EmptyHeapException {

		if (getLength() < 1) {
			throw new EmptyHeapException();
		}

		T head = heap.get(0);
		swap(0, getLength() - 1);
		heap.remove(getLength() - 1);	
		heapify();
		return head;

	}

	public int getLength() {
		return heap.size();
	}

	public void print() {
		
		for (int i = 0; i < getLength(); i++) {
			System.out.print(heap.get(i).toString() + " ");
		}

		System.out.println();
	}


}

