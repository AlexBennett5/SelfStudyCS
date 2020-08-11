
package Singleton;

import java.util.Random;

public class StockMarket {

	private static StockMarket sm = new StockMarket();
	private int sharesIn;
	private double sharePrice;
	private Random rand = new Random();

	private StockMarket() {
		int sharesIn = 100;
		double sharePrice = 10.0;
	};

	public synchronized StockMarket getInstance() {
		return sm;
	}

	public int deductShares(int num) {

		if (num > sharesIn) {
			int shr = sharesIn;
			sharesIn = 0;
			updateSharePrice();
			return shr;
		}

		sharesIn -= num;
		updateSharePrice();
		return num;
	}

	public void addShares(int num) {

		sharesIn += num;
		updateSharePrice();

	}

	public void updateSharePrice() {

		sharePrice = (double)sharesIn/(rand.nextDouble()*100.0);

	}

	public double getCurrentValue(int shares) {

		return (double)shares*sharePrice;

	}
	
}

