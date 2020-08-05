
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MoscowPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public MoscowPlan() {
		TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 39.99;
	}

	public String getName() {
		return "Moscow Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

