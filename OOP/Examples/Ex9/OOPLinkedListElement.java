
package Ex9;

public class OOPLinkedListElement implements Cloneable {

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

	@Override
	public OOPLinkedListElement clone() {
		
		try {
			OOPLinkedListElement c = (OOPLinkedListElement) super.clone();
			
			if (this.getNext() != null) {
				c.setNext((OOPLinkedListElement) this.getNext().clone());
			}

			return c;

		} catch (CloneNotSupportedException ex) {

			throw new RuntimeException("Problem with superclass", ex);

		}
	}

}

