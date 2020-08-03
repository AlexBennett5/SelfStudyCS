
package Decorator;

public class ShiftLeftEncrypt implements IComponent {

	private final IComponent data;

	public ShiftLeftEncrypt(IComponent data) {
		this.data = data;
	}

	public char[] encrypt() {

		char[] arr = data.encrypt();
		
		int n = arr.length;
		char fin = arr[0];

		for (int i = 0; i < n-1; i++) {
			arr[i] = arr[i+1];
		}

		arr[n-1] = fin;

		return arr;

	}

	public String getName() {
		return "ShiftLeftEncryption(" + data.getName() + ")";
	}

}

