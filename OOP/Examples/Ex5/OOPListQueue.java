
package Ex5;

public class OOPListQueue implements OOPQueue {

	private OOPLinkedList head;
	private OOPLinkedList tail;

	OOPListQueue() {

		head = new OOPLinkedList();
		tail = new OOPLinkedList();
	}

	public void norm() {

		if (head.listLength() == 0 && tail.listLength() != 0) {
			head = tail.reverseList();
			tail = new OOPLinkedList();
		}

	}

	public void enqueue(int v) {

		tail.addHead(v);
		norm();

	}

	public void dequeue() {

		head.removeHead();
		norm();

	}

	public boolean qnull() {

		if (head.listLength() == 0 && tail.listLength() == 0)
			return true;

		return false;

	}

	public int qhead() {

		if (!qnull()) {
			return head.getHead();
		}

		System.out.println("Empty Queue, printing -1");
		return -1;

	}

	public void printQueue() {

		System.out.println("Head:");
		head.printList();
		System.out.println("Tail:");
		tail.printList();

	}


}

