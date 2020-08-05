
package FactoryMethod;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HongKongPlan implements IPlan {

	private Calendar c;
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public HongKongPlan() {
		TimeZone tz = TimeZone.getTimeZone("Asia/Hong_Kong");
		c = Calendar.getInstance(tz);
	}

	public double monthlyCost() {
		return 99.99;
	}

	public String getName() {
		return "Hong Kong Plan";
	}

	public String currentTime() {
		return df.format(c.getInstance().getTime());
	}


}

