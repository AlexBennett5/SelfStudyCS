
package ab.practice.tick4star;

public class PatternFormatException extends Exception {

	PatternFormatException(String field, String input) {

		System.out.println("Error: Invalid input for " + field + " field");
		System.out.println("Input was " + input + ", should be integer");
		System.out.println("Remember that valid input is NAME:AUTHOR:WIDTH:HEIGHT:STARTCOL:STARTROW:CELLS");

	}

	PatternFormatException(String format) {

		System.out.println("Error: insufficient number of arguments");
		System.out.println("Input should have 7 fields separated by colons");
		System.out.println("Your input was " + format);
		System.out.println("Remember that valid input is NAME:AUTHOR:WIDTH:HEIGHT:STARTCOL:STARTROW:CELLS");

	}

	PatternFormatException(int row, int col) {

		System.out.println("Error: invalid cell value at row " + row + " and column " + col);
		System.out.println("All starting cell values must be either 0 or 1");

	}

}

