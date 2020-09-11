package Java;

public class Stack {

	private StackNode head;

	class StackNode {
		int data;
		StackNode next;

		StackNode(int val) {
			data = val;
			next = null;
		}
	}

	public Stack() {
		head = null;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void push(int x) {
		StackNode newNode = new StackNode(x);

		if (head == null) {
			head = newNode;
		} else {
			StackNode temp = head;
			head = newNode;
			newNode.next = temp;
		}
		assert(!isEmpty());
		assert(top() != -1);
	}

	public int pop() {
		if (!isEmpty()) {
			int popped = head.data;
			head = head.next;
			return popped;
		} else {
			return -1;
		}
	}

	public int top() {
		if (!isEmpty())
			return head.data;
		else
			return -1;
	}

	public static void main(String[] args) {
		Stack stk = new Stack();
		for (int i = 0; i < 10; i++)
			stk.push(i);
		for (int i = 0; i < 11; i++)
			System.out.println(stk.pop() + ", " + stk.top());
		System.out.println("Empty? " + stk.isEmpty());
	}

}
