
package Observer;

public class NormalFeed implements IObserver, IDisplay {

	private IObservable pub;
	private String headline;

	public NormalFeed(IObservable pub) {
		this.pub = pub;
		this.headline = "";
	}

	public void update(String headline) {
		this.headline = headline;
		display();
	}

	public void display() {

		System.out.println("Normal Feed: " + headline);

	}


}

