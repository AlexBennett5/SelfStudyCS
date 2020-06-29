
package Ex5;


class OOPArrayList implements OOPList {

	private int[] arr;
	private int elements;

	OOPArrayList() {
		arr = new int[0];
		elements = 0;
	}

	public void addHead(int v) {
		addLeft(v);
	}

	public void removeHead() {
		removeLeft();
	}

	public void removeLeft() {

		if (elements == 0)
			return;

		if (elements == 1)
			arr[0] = 0;

		for (int i=0; i<elements-1; i++) {
			arr[i] = arr[i+1];
		}

		arr[elements-1] = 0;
		elements--;

	}



	public void addLeft(int v) {

		if (elements == arr.length) {
			int[] newarr = new int[arr.length+1];
			copyLeft(newarr);
			changeArr(newarr);
			arr[0] = v;
			elements++;
		} else {
			
			elements++;
			for (int i = elements-1; i > 0; i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = v;

		}


	}

	public void addRight(int v) {

		if (elements == arr.length) {
			int[] newarr = new int[2*arr.length];
			copyRight(newarr);
			changeArr(newarr);
		}

		arr[elements] = v;
		elements++;

	}

	public int getHead() {
		return arr[0];
	}

	private void changeArr(int[] cpy) {
		this.arr = cpy;
	}

	private void copyRight(int[] cpy) {

		for (int i = 0; i<arr.length; i++) {
			cpy[i] = arr[i];
		}

	}

	private void copyLeft(int[] cpy) {

		cpy[0] = 0;

		for (int i = 0; i<arr.length; i++) {
			cpy[i+1] = arr[i];
		}

	}

	public int getNth(int n) {
		if (n >= elements) {
			System.out.println("Invalid index. Printing -1");
			return -1;
		}

		return arr[n];
	}

	public int listLength() {
		return elements;
	}



}

