
package ab.practice.examples;

class PrimitiveInt {

	public static void main(String[] args) {
	
		int x = 0x55 >> 4;
		int y = 0x55 << 7;

		System.out.println("x= " + x + " and y=" + y);

		System.out.println(1 & (0x55 >> 4));

	}

}

