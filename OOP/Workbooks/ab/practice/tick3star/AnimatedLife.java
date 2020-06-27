
package ab.practice.tick3star;

class AnimatedLife {

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

	public static void main(String[] args) throws Exception {

		Pattern p = new Pattern(args[0]);
		int framecount = Integer.parseInt(args[1]);
		String file = args[2];
		
		boolean[][] world = new boolean[p.getHeight()][p.getWidth()];
		p.initialise(world);

		OutputAnimatedGif gif = new OutputAnimatedGif(file);
	
		while (framecount > 0) {

			gif.addFrame(world);
			world = nextGeneration(world);
			framecount--;
		}

		gif.close();

	}

}

