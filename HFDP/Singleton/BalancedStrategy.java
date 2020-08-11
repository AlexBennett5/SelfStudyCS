
package Singleton;

import java.util.Random;

public class BalancedStrategy implements IStrategy {
	
	private Random rand = new Random();

	public int shareStrat(int shares) {
		StockMarket sm = StockMarket.getInstance();
		int fract = rand.nextInt(10) + 1;

		int sell = ((fract/2)*shares)/fract;
		int buy = ((fract/2)*shares)/fract;

		sm.addShares(sell);
		return rand.nextInt(50) + sm.deductShares(buy);
	}
	
	public double shareValue(int shares) {
		StockMarket sm = StockMarket.getInstance();
		return sm.getCurrentValue(shares);
	}

}

