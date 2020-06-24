
package ab.practice.tick3;

class ArrayLife {

	public static boolean getCell(boolean[][] world, int col, int row) {

		if (row < 0 || col < 0 || row > world.length - 1 || col > world[row].length - 1)
			return false;
		return world[row][col];

	}

	public static void setCell(boolean[][] world, int col, int row, boolean value) {
	
		if (row < 0 || col < 0 || row > world.length - 1 || col > world[row].length - 1)
			return;

		world[row][col] = value;
	}

	public static void print(boolean[][] world) {
		
		System.out.println("-");
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				System.out.print(getCell(world, col, row) ? "#" : "_");
			}
			System.out.println();
		}
		
	}

	public static int countNeighbours(boolean[][] world, int col, int row) {

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

	public static boolean computeCell(boolean[][] world, int col, int row) {

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

	public static boolean[][] nextGeneration(boolean[][] world) {

		boolean[][] nextWorld = new boolean[world.length][world[0].length];

		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				boolean nextCell = computeCell(world, col, row);
				setCell(nextWorld, col, row, nextCell);
			}
		}

		return nextWorld;	

	}

	public static void play(boolean[][] world) throws Exception {
		int userResponse = 0;
		while (userResponse != 'q') {
			print(world);
			userResponse = System.in.read();
			world = nextGeneration(world);
		}
	}

	public static void main(String[] args) throws Exception {

		int size = Integer.parseInt(args[0]);
		long initial = Long.decode(args[1]);
		boolean[][] world = new boolean[size][size];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				world[i+size/2-4][j+size/2-4] = PackedLong.get(initial, i*8+j);
			}
		}

		play(world);
	}

}

