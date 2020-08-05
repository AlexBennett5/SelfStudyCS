
package FactoryMethod;

public class AmericanPlanFactory implements IFactory {

	public IPlan generatePlan(String str) throws InvalidPlanException {

		if (str.equals("NY")) {
			return new NewYorkPlan();
		} else if (str.equals("CHI")) {
			return new ChicagoPlan();
		} else if (str.equals("LA")) {
			return new LosAngelesPlan();
		} else {
			throw new InvalidPlanException("Error: Invalid city code");
		}

	}

}

