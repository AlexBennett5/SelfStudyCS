

package Ex5;


class OOPArrayList implements OOPList {

        protected int[] arr;
        protected int head;
	protected int tail;

        OOPArrayList() {
                arr = new int[2];
                head = 1;
		tail = 1;
        }

        public void addHead(int v) {
                addLeft(v);
        }

        public void removeHead() {
                removeLeft();
        }

        public void removeLeft() {

		if (this.listLength() == 0)
			return;

		head++;
        }

	public void addLeft(int v) {
				
		if (head == 0)
			resizeList();
                
		head--;
		arr[head] = v;

        }

        public void addRight(int v) {

             	if (tail == arr.length) 
			resizeList();
		

		tail++;
		arr[tail-1] = v;

        }

	private void resizeList() {

		int length = listLength();
		int[] newarr = new int[2*length+2];
		int newhead = (int) Math.floor(length/2) + 1;
		int newtail = newhead + length;

		for (int i=0; i<length; i++) {
			newarr[newhead + i] = arr[head+i];
		}

		arr = newarr;
		head = newhead;
		tail = newtail;

	}

	public int getHead() {
               return arr[head];
        }

	public int getNth(int n) {
                
		if (n >= listLength()) {
			System.out.println("Invalid index. Printing zero");
			return -1;
		}

		return arr[head + n];

        }

        public int listLength() {
                return tail - head;
        }

}


