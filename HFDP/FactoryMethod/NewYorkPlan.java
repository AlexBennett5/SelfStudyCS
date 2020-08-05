
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NewYorkPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public NewYorkPlan() {
		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 199.99;
	}

	public String getName() {
		return "NY Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

