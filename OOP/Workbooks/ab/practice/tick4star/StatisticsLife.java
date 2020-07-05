
package ab.practice.tick4star;

import java.util.List;
import java.util.LinkedList;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.IOException;

class StatisticsLife {

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

	public static Statistics analyse(Pattern p) throws PatternFormatException {

		System.out.println("Analysing " + p.getName());
		return new Statistics(p);

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

			String longestStart = "N/A";
			int longestStartVal = 0;
			String longestCycle = "N/A";
			int longestCycleVal = 0;
			String maxGrowth = "N/A";
			double maxGrowthVal = 0.0;
			String maxDeath = "N/A";
			double maxDeathVal = 0.0;
			String maxPop = "N/A";
			int maxPopVal = 0;

			for (Pattern p : patlist) {

				Statistics stats = analyse(p);

				if (stats.getLoopStart() > longestStartVal) {
					longestStartVal = stats.getLoopStart();
					longestStart = p.getName();
				}

				if (stats.getLoopEnd() > longestCycleVal) {
					longestCycleVal = stats.getLoopEnd();
					longestCycle = p.getName();
				}

				if (stats.getMaximumGrowthRate() > maxGrowthVal) {
				       	maxGrowthVal = stats.getMaximumGrowthRate();
					maxGrowth = p.getName();
				}

				if (stats.getMaximumDeathRate() > maxDeathVal) {
					maxDeathVal = stats.getMaximumDeathRate();
					maxDeath = p.getName();	
				}

				if (stats.getMaximumPopulation() > maxPopVal) {
					maxPopVal = stats.getMaximumPopulation();
					maxPop = p.getName();
				}

			}

			System.out.println("Longest start: " + longestStart + " (" + longestStartVal + ")");
			System.out.println("Longest cycle: " + longestCycle + " (" + longestCycleVal + ")");
			System.out.println("Largest growth rate: " + maxGrowth + " (" + maxGrowthVal + ")");
			System.out.println("Largest death rate: " + maxDeath + " (" + maxDeathVal + ")");
			System.out.println("Largest population: " + maxPop + " (" + maxPopVal + ")");

		} catch (ArrayIndexOutOfBoundsException ex) {

			System.out.println("Error: Invalid # of arguments. Input can be URL/textfile or URL/textfile & index number, nothing more");

		} catch (PatternFormatException ex) {

	
		} 
	
	
	}

}

