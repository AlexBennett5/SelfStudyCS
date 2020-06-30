
package Ex4;

public class OOPSortedLinkedList extends OOPLinkedList {

	@Override
	public void addHead(int v) {

		OOPLinkedListElement curr;
		OOPLinkedListElement ins = new OOPLinkedListElement(v);

		if (getHeadNode() == null || getHead() >= v) {
			ins.setNext(getHeadNode());
			setHeadNode(ins);
			return;
		}

		curr = getHeadNode();
	
		while (curr.getNext() != null && curr.getNext().getData() < v) {
			curr = curr.getNext();
		}	

		ins.setNext(curr.getNext());
		curr.setNext(ins);

	}

	public static void main(String[] args) {

		OOPSortedLinkedList test = new OOPSortedLinkedList();
		test.addHead(3);
		test.addHead(2);
		test.addHead(9);
		test.addHead(8);
		test.addHead(7);
		test.addHead(1);
		test.addHead(10);
		test.addHead(4);


		while (test.getHeadNode() != null) {
			System.out.println(test.getHead());
			test.removeHead();
		}

	}

}

