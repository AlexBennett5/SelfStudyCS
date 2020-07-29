
package Tick1Star;

import java.lang.Comparable;

public interface MaxHeapInterface< T extends Comparable<T> > {

	public void insert(T e);

	public T popMax() throws EmptyHeapException;

	public int getLength();

}

