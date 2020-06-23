package ab.practice.ex2;

public class SearchSet {

	private int mElements;
	private BinaryTreeNode mHead;

	SearchSet() {
		mElements = 0;
		mHead = null;
	}

	public void insert(int val) {
		if (!contains(val)) {
			mHead = insertRec(mHead, val);
			mElements++;
		} else {
			return;
		}
	}

	public BinaryTreeNode insertRec(BinaryTreeNode node, int val) {

		if (node == null) {
			node = new BinaryTreeNode(val);
			return node;
		}

		if (val < node.getValue()) {
			node.setLeft(insertRec(node.getLeft(), val));
		} else if (val > node.getValue()) {
			node.setRight(insertRec(node.getRight(), val));
		}

		return node;

	}

	public int getNumberElements() {
		return mElements;
	}

	public boolean contains(int val) {

		return containsRec(mHead, val);

	}

	public boolean containsRec(BinaryTreeNode node, int val) {

		if (node == null) { return false; }

		if (val == node.getValue()) {
			return true;
		} else if (val < node.getValue()) {
			return containsRec(node.getLeft(), val);
		} else if (val > node.getValue()) {
			return containsRec(node.getRight(), val);
		}

		return false;
	}

	public void inorder() {
		inorderRec(mHead);
	}

	public void inorderRec(BinaryTreeNode node) {
		if (node != null) {
			inorderRec(node.getLeft());
			System.out.println(node.getValue());
			inorderRec(node.getRight());
		}
	}

	public static void main (String[] args) {

		SearchSet test = new SearchSet();

		test.insert(4);
		test.insert(7);
		test.insert(10);
		test.insert(2);
		test.insert(3);
		test.insert(100);
		test.insert(4);
		test.insert(10);

		test.inorder();

		System.out.println("Set contains " + test.getNumberElements() + " elements (should be 6)");

		System.out.println("Set contains 4? " + test.contains(4) + " (should be true)");
		System.out.println("Set contains 20? " + test.contains(20) + " (should be false)");

	}

}
