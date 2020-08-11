
package Singleton;

import java.lang.Runnable;
import java.lang.Exception;
import java.util.Random;

public class Broker implements Runnable {

	private String name;
	private int shares;
       	private double shareVal;
	private int delay;

	private IStrategy strat;

	public Broker(String name, IStrategy strat) {
		this.name = name;
		this.strat = strat;

		Random rand = new Random();
		delay = rand.nextInt(999);

		shares = 100;
		shareVal = strat.shareValue(shares);
	}

	public void makeTrade() {
		shares = strat.shareStrat(shares);
		shareVal = strat.shareValue(shares);
	}

	public void run() {

		while (true) {
		
			try {
				System.out.println("Broker " + name + " makes trade");
				makeTrade();
				System.out.println("Broker " + name + " has " + shares + " shares, worth " + shareVal);
				Thread.sleep(delay);
	
			} catch (Exception ex) {
				System.out.println("Broker " + name + " dropped from trading");
			}

		}
	}

}

