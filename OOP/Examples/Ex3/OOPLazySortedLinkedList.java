
package Ex3;

public class OOPLazySortedLinkedList extends OOPSortedLinkedList {

	private OOPLinkedListElement unsorted;

	@Override
	public void addHead(int v) {

		OOPLinkedListElement node = new OOPLinkedListElement(v);
		node.setNext(unsorted);
		unsorted = node;
	
	}

	public OOPLinkedListElement sort() {

		while (unsorted != null) {

			super.addHead(unsorted.getData());
			unsorted = unsorted.getNext();

		}

		return getHeadNode();

	}

	public static void main(String[] args) {

		OOPLazySortedLinkedList test = new OOPLazySortedLinkedList();

		test.addHead(3);
		test.addHead(5);
		test.addHead(1);
		test.addHead(10);

		test.sort();

		System.out.println(test.getHead());
		System.out.println(test.getHeadNode().getNext().getData());

	}

}

