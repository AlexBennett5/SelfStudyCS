
package ab.practice.tick4;

import java.util.List;
import java.util.LinkedList;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.IOException;

class LoaderLife {

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

	
		try {

			List<Pattern> patlist = new LinkedList<Pattern>();;

			if (args[0].startsWith("http://") || args[0].startsWith("https://")) {
				
				try {
					patlist = PatternLoader.loadFromURL(args[0]);
				} catch (IOException ex) {
					System.out.println("An error occured when loading the patterns from a URL");

				}

			} else {

				try {
				
					patlist = PatternLoader.loadFromDisk(args[0]);
				} catch (IOException ex) {
					System.out.println("An error occured when loading the patterns from a file");

				}
			}

			if (args.length == 1) {

				int index = 0;

				for (Pattern p : patlist) {
					System.out.println(index + ") " + p.getName() + ":" + p.getAuthor() + ":" + p.getWidth() + ":" + p.getHeight() + ":" + p.getStartCol() + ":" + p.getStartRow() + ":" + p.getCells());
					index++;
				}

			} else if (args.length == 2) {

				int index = -1;
				
				try {
					index = Integer.parseInt(args[1]);
				
				} catch (NumberFormatException ex) {

					System.out.println("Error: The second argument must be an integer value");
				
				}


				try {

					Pattern p = patlist.get(index);
					boolean[][] world = new boolean[p.getHeight()][p.getWidth()];
					p.initialise(world);
					play(world);
				
				} catch (IndexOutOfBoundsException ex) {

					System.out.println("Error: invalid index " + index);

				}
				
			} else {

				throw new ArrayIndexOutOfBoundsException();
			}	


		} catch (ArrayIndexOutOfBoundsException ex) {

			System.out.println("Error: Invalid # of arguments. Input can be URL/textfile or URL/textfile & index number, nothing more");

		} catch (PatternFormatException ex) {

	
		} 
	
	
	}

}

