
package Decorator;

public class SubtractEncrypt implements IComponent {

	private final IComponent data;

	public SubtractEncrypt(IComponent data) {
		this.data = data;
	}

	public char[] encrypt() {
		
		char[] arr = data.encrypt();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
		       arr[i] -= 1;
		}	       

		return arr;

	}

	public String getName() {
		return "SubtractEncryption(" + data.getName() + ")";
	}

}

