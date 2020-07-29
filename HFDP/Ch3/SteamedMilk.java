
package Ch3;

public class SteamedMilk extends CondimentDecorator {

	Beverage beverage;

	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", SteamedMilk";
	}

	public double cost() {
		return beverage.cost() + 0.10;
	}

}

