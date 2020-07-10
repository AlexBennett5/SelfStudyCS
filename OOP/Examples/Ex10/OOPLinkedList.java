
package Ex10;

import java.lang.IndexOutOfBoundsException;

public class OOPLinkedList<T> implements OOPList<T> {

	private OOPLinkedListElement<T> head;

	OOPLinkedList() {
		head = null;
	}

	public void addHead(T obj) {
		OOPLinkedListElement<T> h = new OOPLinkedListElement<T>(obj);
		h.setNext(head);
		head = h;
	}

	public void removeHead() {
		if (head == null) { return; }
		head = head.getNext();
	}

	public T getHead() {
		return head.getData();
	}

	public OOPLinkedListElement<T> getHeadNode() {
		return head;
	}

	public void setHeadNode(OOPLinkedListElement<T> node) {
		head = node;
	}

	public T getNth(int n) {

		OOPLinkedListElement<T> node = head;

		while(n > 0) {
			node = node.getNext();
			n--;
		}

		return node.getData();
		
	}

	public int listLength() {

		OOPLinkedListElement<T> node = head;
		int count = 0;

		while (node != null) {
			node = node.getNext();
			count++;
		}

		return count;

	}

	public OOPLinkedList<T> reverseList() {

		OOPLinkedList<T> res = new OOPLinkedList<T>();
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

	public static void main(String[] args) {

		OOPLinkedList<Integer> int_test = new OOPLinkedList<Integer>();
		int_test.addHead(3);
		int_test.addHead(4);
		int_test.addHead(5);

		OOPLinkedList<Double> dub_test = new OOPLinkedList<Double>();
		dub_test.addHead(4.5);
		dub_test.addHead(5.6);

		OOPLinkedList<String> str_test = new OOPLinkedList<String>();
		str_test.addHead("Hello");
		str_test.addHead("World");

		OOPLinkedList<Character> char_test = new OOPLinkedList<Character>();
		char_test.addHead('a');
		char_test.addHead('b');

		int_test.printList();
		dub_test.printList();
		str_test.printList();
		char_test.printList();

	}

}

