
package Ch2;

import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {

	private float temp;
	private float humidity;
	private float pressure;

	public WeatherData() {}

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float t, float h, float p) {
		temp = t;
		humidity = h;
		pressure = p;
		measurementsChanged();
	}

	public float getTemperature() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}

