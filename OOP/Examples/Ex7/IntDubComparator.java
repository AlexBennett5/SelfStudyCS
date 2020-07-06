
package Ex7;

import java.util.Comparator;

class IntDubComparator implements Comparator<String> {

	public int compare(String s1, String s2) {

		String[] num1 = s1.split(",");		
		String[] num2 = s2.split(",");

		int s1i1 = Integer.parseInt(num1[0].trim());
		int s1i2 = Integer.parseInt(num1[1].trim());
		int s2i1 = Integer.parseInt(num2[0].trim());
		int s2i2 = Integer.parseInt(num2[1].trim());

		if (s1i1 != s2i1) {
			return s1i1 - s2i1;
		} else {
			return s1i2 - s2i2;
		}

	}

}

