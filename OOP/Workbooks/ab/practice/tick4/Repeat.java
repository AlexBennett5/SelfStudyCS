
package ab.practice.tick4;

public class Repeat {

	public static void main(String[] args) {

		System.out.println(parseAndRep(args));

	}

	public static String parseAndRep(String[] args) {


		try {

			int times = Integer.parseInt(args[1]);
			String res = "";

			while (times > 0) {
				res = res + args[0] + " ";
				times--;
			}

			return res;
		
		} catch (ArrayIndexOutOfBoundsException ex) {

			return "Error: insufficient arguments";
		
		} catch (NumberFormatException ex) {

			return "Error: second argument is not positive integer";

		}



	}

}

