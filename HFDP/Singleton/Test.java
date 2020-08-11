
package Singleton;

import java.lang.Thread;
import java.lang.Exception;

public class Test {

	public static void main(String[] args) {

		Broker aggro = new Broker("Aggro Trader", new AggroStrategy());
		Broker balan1 = new Broker("Balanced Trader 1", new BalancedStrategy());
		Broker balan2 = new Broker("Balanced Trader 2", new BalancedStrategy());
	
		Thread b1 = new Thread(aggro);
		Thread b2 = new Thread(balan1);
		Thread b3 = new Thread(balan2);

		b1.start();
		b2.start();
		b3.start();

	}

}

