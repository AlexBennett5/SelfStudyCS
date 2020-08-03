
package Decorator;

public class BaseComponent implements IComponent {

	private char[] arr;

	public BaseComponent(char[] arr) {
		this.arr = arr.clone();
	}

	public char[] encrypt() {
		return arr.clone();
	}

	public String getName() {
		return "Base";
	}

}

