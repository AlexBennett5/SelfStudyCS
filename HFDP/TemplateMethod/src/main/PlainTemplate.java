
package src.main;

public class PlainTemplate extends AbstractTemplate {

	public PlainTemplate(User user) {
		super(user);
	}

	protected void printBorder() {
		System.out.println("/////////////////////////////////////");
	}

}

