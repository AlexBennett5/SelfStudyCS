
package Singleton;

import java.util.Random;

public class AggroStrategy implements IStrategy {

	private Random rand = new Random();

	public int shareStrat(int shares) {
		StockMarket sm = StockMarket.getInstance();
		int fract = rand.nextInt(10) + 1;

		int sell = shares/fract;
		int buy = ((fract-1)*shares)/fract;

		sm.addShares(sell);
		return rand.nextInt(100) + sm.deductShares(buy);
	}
	
	public double shareValue(int shares) {
		StockMarket sm = StockMarket.getInstance();
		return sm.getCurrentValue(shares);
	}

}

