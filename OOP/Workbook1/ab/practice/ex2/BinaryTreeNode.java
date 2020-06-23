
package ab.practice.ex2;

public class BinaryTreeNode {

	private int mValue;
	private BinaryTreeNode mRight;
	private BinaryTreeNode mLeft;

	BinaryTreeNode(int val) {
		mValue = val;
		mRight = null;
		mLeft = null;
	}

	public int getValue() {
		return mValue;
	}

	public void setValue(int val) {
		mValue = val;
	}

	public BinaryTreeNode getLeft() {
		return mLeft;
	}

	public BinaryTreeNode getRight() {
		return mRight;
	}

	public void setRight(BinaryTreeNode node) {
		mRight = node;
	}

	public void setLeft(BinaryTreeNode node) {
		mLeft = node;
	}

}
