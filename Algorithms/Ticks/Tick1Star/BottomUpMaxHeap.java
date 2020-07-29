
package Tick1Star;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Comparable;

public class BottomUpMaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private ArrayList<T> heap;

	public BottomUpMaxHeap(List<T> x) {
		
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
		siftDown(0);	
		return head;
	}

	public int leafSearch(int ind) {
		int j = ind;
		int n = getLength();
		
		while (rightchild(j) < n) {
			int r = rightchild(j);
			int l = leftchild(j);

		       	if (heap.get(r).compareTo(heap.get(l)) == 1) {
				j = r;
			} else {
				j = l;
			}
		}

		if (leftchild(j) < n) j = leftchild(j);
		return j;	
	}

	public void siftDown(int ind) {
	
		int j = leafSearch(ind);

		while (heap.get(ind).compareTo(heap.get(j)) == 1) {
			j = parent(j);
		}

		T k = heap.get(j);
		heap.set(j, heap.get(ind));

		while (j > ind) {
			T temp = heap.get(parent(j));
			heap.set(parent(j), k);
			k = temp;
			j = parent(j);
		}

	}

	public static int leftchild(int j) {
		return 2*j+1;
	}

	public static int rightchild(int j) {
		return 2*j+2;
	}

	public static int parent(int j) {
		return (j-1)/2;
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

	public static void main(String[] args) {

		int[] arr = {3,5,123,42,8447,123,133,343,9,1001,34,66};

		List<Integer> a = new ArrayList<Integer>();
		
		for (int i : arr) {
			a.add(i);
		};

		MaxHeap mh = new MaxHeap(a);
		BottomUpMaxHeap bh = new BottomUpMaxHeap(a);

		System.out.println("Max Heap before extraction: ");
		mh.print();
		System.out.println("Bottom Up Heap before extraction: ");
		bh.print();

		try {
			System.out.println("Max Heap after extraction: ");
			mh.popMax();
			mh.print();
		} catch (EmptyHeapException e) {
			System.out.println("Max Heap is empty");
		}

		try {
			System.out.println("Bottom Up Heap after extraction: ");
			bh.popMax();
			bh.print();
		} catch (EmptyHeapException e) {
			System.out.println("Bottom Up Heap is empty");
		}
	
	}


}

