
package FactoryMethod;

import java.util.Scanner;

public class Test{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your region number.\n1. American 2. Eurasian");
		int choice = Integer.parseInt(sc.nextLine());

		while(choice<1||choice>2) {

			System.out.println("Invalid region choice. Please choose from the options:\n1. American 2. Eurasian");
			choice = Integer.parseInt(sc.nextLine());

		}

		IFactory fact;

		if (choice == 1) {
			fact = new AmericanPlanFactory();
		} else {
			fact = new EurasianPlanFactory();
		}

		try {

			System.out.println("Enter your city code to see your city's current rate");
			String code = sc.nextLine();
			IPlan plan = fact.generatePlan(code);
			System.out.println("This is the " + plan.getName() + " with rate " + plan.monthlyCost() + " per month\n The current time in this city is " + plan.currentTime());

		} catch (InvalidPlanException ex) {
			System.out.println(ex.getMessage());
		}		


	}

}

