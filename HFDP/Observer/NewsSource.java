
package Observer;

import java.util.ArrayList;

public class NewsSource implements IObservable {

	private ArrayList<IObserver> subs;
	private String headline;

	public NewsSource() {

		subs = new ArrayList<IObserver>();

	}


	public void addObserver(IObserver obs) {

		subs.add(obs);

	}

	public void removeObserver(IObserver obs) {
		subs.remove(obs);
	}

	public void notifyObservers() {
		
		for (IObserver obs : subs) {
			obs.update(headline);
		}
	}

	public void checkNews(String test) {

		if (!test.equals(headline)) {
			headline = test;
			notifyObservers();
		}
	}

}

