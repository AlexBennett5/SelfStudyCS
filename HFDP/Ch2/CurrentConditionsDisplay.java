
package Ch2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	private float temp;
	private float humidity;
	private Observable observable;

	public CurrentConditionsDisplay(Observable observable) {
		observable = observable;
		observable.addObserver(this);	
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			temp = weatherData.getTemperature();
			humidity = weatherData.getHumidity();
			display();
		}
	}

	public void display() {
		System.out.println("Current conditions: " + temp + "F degress and " + humidity + "% humidity");
	}

}

