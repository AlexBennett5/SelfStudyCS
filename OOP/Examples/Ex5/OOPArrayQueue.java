
package Ex5;

public class OOPArrayQueue extends OOPArrayList implements OOPQueue {


        public void enqueue(int v) {

		addRight(v);

        }


        public void dequeue() {

		removeHead();

        }

        public boolean qnull() {

		if (listLength() == 0)
			return true;

		return false;

        }

        public int qhead() {

		return getHead();

        }


}

