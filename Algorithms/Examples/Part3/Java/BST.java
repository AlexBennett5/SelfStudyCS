package Java;

public class BST {

	class Node {
		int key;
		String value;
		Node left;
		Node right;
		
		public Node(int key, String value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node head;

	public BST() {
		head = null;
	}

	public void insert(int key, String value) {
		head = insert_aug(head, key, value);
	}

	private Node insert_aug(Node n, int key, String value) {
		if (n == null) {
			n = new Node(key, value); 
			return n;
		} else {
			if (key < n.key) 
				n.left = insert_aug(n.left, key, value);
			else if (key > n.key)
				n.right = insert_aug(n.right, key, value);
			return n;
		}
	}

	public String search(int key) {
		return search_aug(head, key);
	}

	private String search_aug(Node n, int key) {
		if (n == null)
			return null;
		else if (n.key == key)
			return n.value;
		else if (key < n.key)
			return search_aug(n.left, key);
		else
			return search_aug(n.right, key);
	}		

	public void delete(int key) {
		head = delete_aug(head, key);
	}

	public Node delete_aug(Node n, int key) {
		if (n == null)
			return n;
		if (key == n.key) {
			if (n.left == null) return n.right;
			else if (n.right == null) return n.left;

			Node deleted = n;
			n = findMin(n.right);
			n.right = deleteMin(deleted.right);
			n.left = deleted.left;
		} else if (key < n.key) {
			n.left = delete_aug(n.left, key);
		} else {
			n.right = delete_aug(n.right, key);
		}
		return n;
	}
	
	private Node findMin(Node n) {
		while (n.left != null)
			n = n.left;
		return n;
	}

	private Node deleteMin(Node n) {
		if (n.left == null)
			return n.right;
		n.left = deleteMin(n.left);
		return n;
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(4, "Hey");
		tree.insert(6, "Hello");
		tree.insert(1, "Greetings");
		tree.insert(10, "Farewell");
		System.out.println("4: " + tree.search(4));
		System.out.println("6: " + tree.search(6));
		System.out.println("10: " + tree.search(10));
		tree.delete(10);
		System.out.println("10 (after deletion): " + tree.search(10));
	}
}
