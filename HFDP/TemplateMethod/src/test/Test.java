
package src.test;

import src.main.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	private static final String filepath = "userinfo.ser";

	public static void main(String[] args) {

		User storedUser = storeAndRetrieve(new User("Johnny Uz", "jjuz@java.com", "pass123word"));
	
		int templateChoice = Integer.parseInt(args[0]);
		
		AbstractTemplate templ = getTemplate(templateChoice, storedUser);

		templ.printTemplate();


	}

	public static AbstractTemplate getTemplate(int templateChoice, User user) {
		AbstractTemplate templ;

		if (templateChoice == 0) {
			templ = new ChristmasTemplate(user);
		} else if (templateChoice == 1) {
			templ = new NewYearTemplate(user);
		} else {
			templ = new PlainTemplate(user);
		}

		return templ;


	}

	public static User storeAndRetrieve(User user) {

		serialize(user);
		return deserialize();

	}

	public static void serialize(User user) {

		try {
            		FileOutputStream fos = new FileOutputStream(filepath);
            		ObjectOutputStream output = new ObjectOutputStream(fos);
            		output.writeObject(user);
            		output.close();
        	} catch (IOException ex) {
            		System.err.println(ex);
        	}

	}

	public static User deserialize() {

		User storedUser = null;

		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream input = new ObjectInputStream(fis);
			storedUser = (User) input.readObject();
			input.close();
		} catch (IOException | ClassNotFoundException ex) {
			System.err.println(ex);
		}

		return storedUser;

	}

}

