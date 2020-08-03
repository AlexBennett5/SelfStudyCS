
package Decorator;

public class ShiftRightEncrypt implements IComponent {

	private final IComponent data;

	public ShiftRightEncrypt(IComponent data) {
		this.data = data;
	}

	public char[] encrypt() {

		char[] arr = data.encrypt();

		int n = arr.length;
		char fin = arr[n-1];

		for (int i = n-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}

		arr[0] = fin;

		return arr;

	}

	public String getName() {
		return "ShiftRightEncryption(" + data.getName() + ")";
	}

}

