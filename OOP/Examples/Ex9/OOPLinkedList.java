
package Ex9;

public class OOPLinkedList implements Cloneable {

	private OOPLinkedListElement head;

	OOPLinkedList() {
		head = null;
	}

	public void addHead(int v) {
		OOPLinkedListElement h = new OOPLinkedListElement(v);
		h.setNext(head);
		head = h;
	}

	public void removeHead() {
		if (head == null) { return; }
		head = head.getNext();
	}

	public int getHead() {
		return head.getData();
	}

	public OOPLinkedListElement getHeadNode() {
		return head;
	}

	public void setHeadNode(OOPLinkedListElement node) {
		head = node;
	}

	public int getNth(int n) {

		if (n < 0 || n > listLength()) {
			System.out.println("Invalid index");
			return -1;
		}

		OOPLinkedListElement node = head;

		while(n > 0) {
			node = node.getNext();
			n--;
		}

		return node.getData();

	}

	public int listLength() {

		OOPLinkedListElement node = head;
		int count = 0;

		while (node != null) {
			node = node.getNext();
			count++;
		}

		return count;

	}

	public OOPLinkedList reverseList() {

		OOPLinkedList res = new OOPLinkedList();
		int length = this.listLength();

		for (int i = 0; i < length; i++) {
			res.addHead(this.getNth(i));
		}

		return res;		

	}

	public void printList() {

		int length = listLength();

		for (int i = 0; i < length; i++) {
			System.out.print(getNth(i) + " ");
		}
		System.out.println();

	}

	@Override
	public OOPLinkedList clone() {

		try {

			OOPLinkedList c = (OOPLinkedList) super.clone();
			c.setHeadNode((OOPLinkedListElement) this.getHeadNode().clone());

			return c;

		} catch (CloneNotSupportedException ex) {

			throw new RuntimeException("Problem with superclass", ex);

		}	
		

	}

	public static void main(String[] args) {

		OOPLinkedList test = new OOPLinkedList();
		test.addHead(1);
		test.addHead(2);
		test.addHead(3);
		test.addHead(4);

		System.out.println("Original:");
		test.printList();

		OOPLinkedList copy = test.clone();

		System.out.println("Copy:");
		copy.printList();

		test.removeHead();
		test.removeHead();
		copy.removeHead();

		System.out.println("Original after deleting 2");
		test.printList();
		System.out.println("Copy after deleting 1");
		copy.printList();

	}

	

}

