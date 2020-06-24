
package ab.practice.tick2;

public class PackedLong {

	public static boolean get(long packed, int position) {

		long check = (1 & (packed >> position));
		
		return (check == 1);
	}

	public static long set(long packed, int position, boolean value) {

		if (value) {
			return (packed | (1L << position));
		} else {
			return (packed & ~(1L << position));	
		}
	}

}


	

