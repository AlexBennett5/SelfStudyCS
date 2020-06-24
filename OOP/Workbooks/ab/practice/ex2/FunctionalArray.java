
package ab.practice.ex2;

class FunctionalArray {

	private BinaryTreeNode arr;
	private int maxindex;

	FunctionalArray(int v) {

		if (v <= 0) {
			System.out.println("Invalid value for v");
			return;
		}

		arr = new BinaryTreeNode(0);

		for (int i = 1; i < v; i++) {
			addNode(arr, i);
		}

		maxindex = v - 1;

	}

	public void addNode(BinaryTreeNode node, int k) {

		if (k == 1) {
			node.setLeft(new BinaryTreeNode(0));
			return;
		} else if (k == 2) {
			node.setRight(new BinaryTreeNode(0));
			return;
		} else if (k % 2 == 1) {
			addNode(node.getLeft(), k-1-(k/2));
			return;
		} else {
			addNode(node.getRight(), k-1-(k/2));
			return;
		}

	}

	public void set(int index, int value) {

		if (index > maxindex || index < 0) {
			System.out.println("Invalid index");
			return;
		}

		BinaryTreeNode node = arr;

		while(index != 0) {
			if (index % 2 == 0) {
				node = node.getRight();
			} else {
				node = node.getLeft();
			}

			index = index - 1 - (index/2);
		}

		node.setValue(value);

	}

	public int get(int index) {

		if (index > maxindex || index < 0) {
			System.out.println("Invalid index");
			return -1;
		}

		BinaryTreeNode node = arr;

		while(index != 0) {
			if (index % 2 == 0) {
				node = node.getRight();
			} else {
				node = node.getLeft();
			}

			index = index - 1 - (index/2);
		}

		return node.getValue();

	}

	public static void main(String[] args) {

		FunctionalArray test = new FunctionalArray(8);

		System.out.println("Value at 0: " + test.get(0));
		System.out.println("Value at 7: " + test.get(7));
		System.out.println("Value at 8 (invalid): " + test.get(8));

		test.set(0, 10);
		test.set(4, 302);
		test.set(6, 23);
		test.set(5, 2134);
		test.set(1, 5554);
		test.set(3, 9812);

		System.out.println("Value at 0 (should be 10) " + test.get(0));
		System.out.println("Value at 5 (should be 2134) " + test.get(5));
		System.out.println("Value at 6 (should be 23) " + test.get(6));

	}

}

