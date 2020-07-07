
package ab.practice.tick5;

import java.io.Writer;
import java.awt.Graphics;
import java.io.PrintWriter;

public class TestPackedWorld implements World {

 private int generation;
 private final int width = 8;
 private final int height = 8;
 private long cells;

	public TestPackedWorld() {
		generation = 0;
		cells = 0L;
	 }

 	protected TestPackedWorld(TestPackedWorld prev) {
		generation = prev.generation+1;
		cells = 0L;
 	}
	
 	public boolean getCell(int col, int row) {
		if (row < 0 || col < 0 || row > height - 1 || col > width - 1) return false;

		return ((1 & (cells >> (col + 8*row))) == 1);     
	}
	
	public void setCell(int col, int row, boolean alive) {

		if (row < 0 || col < 0 || row > height - 1 || col > width - 1) return;

		if (alive) {
			cells =  (cells | (1L << (col + 8*row)));
		} else {
			cells =  (cells & ~(1L << (col + 8*row)));
		}
	}

	
	public int getWidth()  { 
		return width;       
	}
 
	public int getHeight()  {
		return height;       
	}
 
	public int getGeneration()  { 
       		return generation;
	}

       	public int getPopulation()  { 
		return 0;	
	}

 	public void print(Writer w)  { 

		PrintWriter pw = new PrintWriter(w);
		pw.println("-");

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				pw.print(getCell(j,i) ? "#" : "_");
			}
			pw.println();
		}

		pw.flush();
	}
 
	public void draw(Graphics g, int width, int height)  { /*Leave empty*/ }

 
	private TestPackedWorld nextGeneration() {
   
   		TestPackedWorld world = new TestPackedWorld(this);
   	
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				world.setCell(j, i, computeCell(j, i));
			}
		}

		return world;
 	}

	private int countNeighbours(int col, int row) {

		int count = 0;
		
		count += getCell(col, row+1) ? 1 : 0;
		count += getCell(col, row-1) ? 1 : 0;
		count += getCell(col+1, row+1) ? 1 : 0;
		count += getCell(col+1, row-1) ? 1 : 0;
		count += getCell(col-1, row+1) ? 1 : 0;
		count += getCell(col-1, row-1) ? 1 : 0;
		count += getCell(col+1, row) ? 1 : 0;
		count += getCell(col-1, row) ? 1 : 0;

		return count;

	}

	private boolean computeCell(int col, int row) {

		boolean liveCell = getCell(col, row);
		int neighbours = countNeighbours(col, row);
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

 	public World nextGeneration(int log2StepSize)  {
   		
		TestPackedWorld world = this;
   		int power = 1<<log2StepSize;


	   	for (int i = 0; i < power; i++)  {
    			world = world.nextGeneration();
   		}
   		
		return world;
	 }

}

