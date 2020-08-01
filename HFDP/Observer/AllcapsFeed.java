
package Observer;

public class AllcapsFeed implements IObserver, IDisplay {

	private IObservable pub;
	private String headline;

	public AllcapsFeed(IObservable pub) {
		this.pub = pub;
		this.headline = "";
	}

	public void update(String headline) {
		this.headline = headline.toUpperCase();
		display();
	}

	public void display() {

		System.out.println("Allcaps Feed: " + headline);

	}

}

