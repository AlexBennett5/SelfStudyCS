
package Ex3;

public class OOPLinkedListElement {

	private int data;
	private OOPLinkedListElement next;

	OOPLinkedListElement(int d) {

		data = d;
		next = null;

	}

	public int getData() {
		return data;
	}

	public OOPLinkedListElement getNext() {
		return next;
	}

	public void setNext(OOPLinkedListElement node) {
		next = node;
	}

}

