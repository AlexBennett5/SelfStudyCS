
package Ch3;

//This is an example of the DECORATOR pattern in action
//

public class CoffeeShop {

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage bev2 = new DarkRoast();
		bev2 = new Mocha(bev2);
		bev2 = new Mocha(bev2);
		bev2 = new Whip(bev2);
		System.out.println(bev2.getDescription() + " $" + bev2.cost());

		Beverage bev3 = new HouseBlend();
		bev3 = new Soy(bev3);
		bev3 = new Mocha(bev3);
		bev3 = new Whip(bev3);
		System.out.println(bev3.getDescription() + " $" + bev3.cost());

	}

}

