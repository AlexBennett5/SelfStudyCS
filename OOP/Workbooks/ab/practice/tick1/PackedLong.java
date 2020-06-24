
package ab.practice.tick1;

public class PackedLong {

	public static boolean get(long packed, int position) {

		long check = (1 & (packed >> position));
		
		return (check == 1);
	}

	public static long set(long packed, int position, boolean value) {

		if (value) {
			return (packed | (1 << position));
		} else {
			
			if (get(packed, position)) {
				return (packed ^ (1 << position));
			} else {
				return packed;
			}
		}
	}

}


	

