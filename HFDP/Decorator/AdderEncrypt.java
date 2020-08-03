
package Decorator;

public class AdderEncrypt implements IComponent {

	private final IComponent data;

	public AdderEncrypt(IComponent data) {
		this.data = data;
	}

	public char[] encrypt() {
		
		char[] arr = data.encrypt();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
		       arr[i] += 1;
		}	       

		return arr;

	}

	public String getName() {
		return "AdderEncryption(" + data.getName() + ")";
	}

}

