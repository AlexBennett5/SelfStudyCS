
package Singleton;

import java.util.Random;

public class StockMarket {

	private static StockMarket sm = new StockMarket();
	private int sharesIn;
	private double sharePrice;
	private Random rand = new Random();

	private StockMarket() {
		int sharesIn = 100;
		double sharePrice = 1000.0;
	};

	public static StockMarket getInstance() {
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

		sharePrice = (sharePrice*(rand.nextDouble())) + (sharesIn*(rand.nextDouble()));

	}

	public double getCurrentValue(int shares) {

		return shares*sharePrice;

	}

	public int getTotalShares() {
		return sharesIn;
	}
	
}

