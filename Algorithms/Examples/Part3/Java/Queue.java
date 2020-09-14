package Java;

public class Queue {

	private int head, tail, capacity;
	private int[] arr;

	public Queue(int capacity) {
		this.capacity = capacity;
		head = tail = 0;
		arr = new int[capacity];
	}

	public boolean isEmpty() {
		return (tail == 0);
	}

	public void enqueue(int x) {
		if (tail == capacity - 1) {
			System.out.println("Queue is full");
			return;
		}
		arr[++tail] = x;
	}

	public int dequeue() {
		if (!isEmpty()) {
			int res = arr[head];
			for (int i = 0; i < tail - 1; i++)
				arr[i] = arr[i + 1];
			if (tail < capacity)
				arr[tail--] = 0;
			return res;
		}
		return -1;	
	}

	public int first() {
		if (!isEmpty())
			return arr[head];
		else
			return -1;
	}

	public static void main(String[] args) {
		Queue q = new Queue(10);
		for (int i = 0; i < 12; i++)
			q.enqueue(i);
		for (int i = 0; i < 12; i++)
			System.out.println(q.dequeue() + ", " + q.first());
	}

}
