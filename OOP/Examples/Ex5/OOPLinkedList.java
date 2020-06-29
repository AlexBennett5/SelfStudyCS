
package Ex5;

public class OOPLinkedList {

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

		for (int i = 0; i < this.listLength(); i++) {
			res.addHead(this.getNth(i));
		}

		return res;		

	}

	public void printList() {

		for (int i = 0; i < listLength(); i++) {
			System.out.print(getNth(i) + " ");
		}
		System.out.println();

	}

	

}

