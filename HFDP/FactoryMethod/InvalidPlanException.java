
package FactoryMethod;

import java.lang.Exception;

public class InvalidPlanException extends Exception {
	public InvalidPlanException(String err) {
		super(err);
	}
}

