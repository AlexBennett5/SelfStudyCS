
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ChicagoPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public ChicagoPlan() {
		TimeZone tz = TimeZone.getTimeZone("America/Chicago");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 45.99;
	}

	public String getName() {
		return "Chicago Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

