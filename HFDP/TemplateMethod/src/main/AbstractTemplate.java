
package src.main;

public abstract class AbstractTemplate {

	private User user;

	public AbstractTemplate(User user) {
		this.user = user;
	}

	public void printTemplate() {
		printBorder();
		printHeader();
		printMessage();
		printUserInfo();
		printGraphic();
		printBorder();

	}

	protected abstract void printBorder();

	protected void printMessage() {}

	protected final void printHeader() {
		System.out.println("YOUR USER INFO");
	}

	protected final void printUserInfo() {
		System.out.println(user.getInfo());
	}

	protected void printGraphic() {}

}

