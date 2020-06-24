
package ab.practice.tick2star;

class TinyLife {

	public static boolean getCell(long world, int col, int row) {

		if (col > 7 || row > 7 || col < 0 || row < 0)
			return false;

		return PackedLong.get(world, (col + 8*row));	
	}

	public static long setCell(long world, int col, int row, boolean value) {

		if (col > 7 || row > 7 || col < 0 || row < 0)
			return world;

		return PackedLong.set(world, (col + 8*row), value);	

	}

	public static void print(long world) {
		
		System.out.println("-");
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				System.out.print(getCell(world, col, row) ? "#" : "_");
			}
			System.out.println();
		}
		
	}

	public static int countNeighbours(long world, int col, int row) {

		int count = 0;
		
		count += getCell(world, col, row+1) ? 1 : 0;
		count += getCell(world, col, row-1) ? 1 : 0;
		count += getCell(world, col+1, row+1) ? 1 : 0;
		count += getCell(world, col+1, row-1) ? 1 : 0;
		count += getCell(world, col-1, row+1) ? 1 : 0;
		count += getCell(world, col-1, row-1) ? 1 : 0;
		count += getCell(world, col+1, row) ? 1 : 0;
		count += getCell(world, col-1, row) ? 1 : 0;

		return count;

	}

	public static boolean computeCell(long world, int col, int row) {

		boolean liveCell = getCell(world, col, row);
		int neighbours = countNeighbours(world, col, row);
		boolean nextCell = false;

		if (neighbours < 2)
			nextCell = false;

		if (liveCell && (neighbours == 2 || neighbours == 3))
			nextCell = true;

		if (neighbours > 3)
			nextCell = false;

		if (!liveCell && neighbours == 3)
			nextCell = true;

		return nextCell;

	}

	public static long nextGeneration(long world) {

		long nextWorld = world;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				boolean nextCell = computeCell(world, col, row);
				nextWorld = setCell(nextWorld, col, row, nextCell);
			}
		}

		return nextWorld;	

	}

	public static void findLoop(long world) {
		
		long[] arr = new long[100];
		long next = world;
		arr[0] = next;

		for (int i = 1; i < 100; i++) {
			next = nextGeneration(next);
			arr[i] = next;
		}

		for (int i = 0; i < 100; i++) {
			for (int j = i+1; j < 100; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(i + " to " + (j-1));
					return;
				}
			}
		}

		System.out.println("No loops found");
	}



	public static void main(String[] args) {

		findLoop(Long.decode(args[0]));
	}

}

