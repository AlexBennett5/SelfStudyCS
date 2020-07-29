
package Ch2;

/*
 * An example of the OBSERVER pattern. 
 * This implementation uses the built in Observable class/Observer interface
 * The built-in Observable is somewhat inflexible, so you can write your own 
 * (eg the Subject & Observer interfaces in this package)
 *
*/

public class WeatherStation {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.9f);
		weatherData.setMeasurements(78, 90, 29.2f);

	}

}

