
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LondonPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public LondonPlan() {
		TimeZone tz = TimeZone.getTimeZone("Europe/London");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 69.99;
	}

	public String getName() {
		return "London Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

