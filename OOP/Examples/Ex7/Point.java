
package Ex7;

class Point implements Comparable<Point> {

	private final int x;
	private final int y;
	private final int z;

	Point(int nx, int ny, int nz) {

		x = nx;
		y = ny;
		z = nz;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int compareTo(Point p) {

		if (this.getZ() < p.getZ()) {
			return -1;
		} else if (this.getZ() > p.getZ()) {
			return 1;
		} else {

			if (this.getY() < p.getY()) {
				return -1;
			} else if (this.getY() > p.getY()) {
				return 1;
			} else {

				if (this.getX() < p.getX()) {
					return -1;
				} else if (this.getX() > p.getX()) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	}

	public static void main(String[] args) {

		Point t1 = new Point(1,2,3);
		Point t2 = new Point(2,2,4);
		Point t3 = new Point(1,2,3);
		Point t4 = new Point(7,8,2);
		Point t5 = new Point(1,2,4);
		Point t6 = new Point(1,2,2);

		System.out.println(t1.compareTo(t3));
		System.out.println(t1.compareTo(t5));
		System.out.println(t1.compareTo(t6));
		System.out.println(t2.compareTo(t4));

	}

}

