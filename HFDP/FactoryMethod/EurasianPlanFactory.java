
package FactoryMethod;

public class EurasianPlanFactory implements IFactory {

	public IPlan generatePlan(String str) throws InvalidPlanException {

		if (str.equals("HK")) {
			return new HongKongPlan();
		} else if (str.equals("MSCW")) {
			return new MoscowPlan();
		} else if (str.equals("LNDN")) {
			return new LondonPlan();
		} else {
			throw new InvalidPlanException("Error: Invalid city code");
		}

	}

}

