
package src.main;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1234L;

	private String userName;
	private String email;
	private Calendar registrationDate;
	private transient String password;

	public User(String userName, String email, String password) {

		this.userName = userName;
		this.email = email;
		this.password = password;
		registrationDate = Calendar.getInstance();

	}

	public String getPasswordString() {

		return (password != null) ? password : "********";

	}

	public String getRegDateString() {

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return df.format(registrationDate.getTime());

	}

	public String getInfo() {

		String info = 
			"Username: " + userName + "\n" +
			"Email: " + email + "\n" +
			"Password :" + getPasswordString() + "\n" +
			"Registration Date: " + getRegDateString();

		return info;

	}
}

