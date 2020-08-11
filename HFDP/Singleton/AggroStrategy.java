
package Singleton;

import java.util.Random;

public class AggroStrategy implements IStrategy {
	
	public static int shareStrat(int shares) {
		StockMarket sm = StockMarket.getInstance();
		Random rand = new Random();
		int fract = rand.nextInt(10) + 1;

		int sell = shares/fract;
		int buy = ((fract-1)*shares)/fract;

		sm.addShares(sell);
		return sm.deductShares(buy);
	}
	
	public static double shareValue(int shares) {
		StockMarket sm = StockMarket.getInstance();
		return sm.getCurrentValue(shares);
	}

}

