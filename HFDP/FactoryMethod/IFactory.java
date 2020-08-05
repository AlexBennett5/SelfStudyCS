
package FactoryMethod;

public interface IFactory {

	public IPlan generatePlan(String str) throws InvalidPlanException;

}

