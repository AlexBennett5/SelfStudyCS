
package src.test;

import src.main.*;
import java.math.RoundingMode;

public class Test {

	public static void main(String[] args) {

		ICalculator[] calcs = {new DefaultCalculator(), new GuavaCalcAdapter(new GuavaCalculator(RoundingMode.CEILING))};
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;

		for (ICalculator calc : calcs) {

			System.out.println(calc.calcName() + " add: " + calc.add(a, 1));
			System.out.println(calc.calcName() + " subtract: " + calc.subtract(b, 1));
			System.out.println(calc.calcName() + " multiply: " + calc.multiply(a, 5));
			System.out.println(calc.calcName() + " divide: " + calc.divide(a, 5));
		}	

	}

}

