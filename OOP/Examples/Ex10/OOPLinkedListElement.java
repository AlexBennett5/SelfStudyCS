
package Ex10;

public class OOPLinkedListElement<T> {

	private T data;
	private OOPLinkedListElement<T> next;

	OOPLinkedListElement(T obj) {

		data = obj;
		next = null;

	}

	public T getData() {
		return data;
	}

	public OOPLinkedListElement<T> getNext() {
		return next;
	}

	public void setNext(OOPLinkedListElement<T> node) {
		next = node;
	}

}

