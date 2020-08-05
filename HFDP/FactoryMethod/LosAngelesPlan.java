
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LosAngelesPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public LosAngelesPlan() {
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 55.99;
	}

	public String getName() {
		return "Los Angeles Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

