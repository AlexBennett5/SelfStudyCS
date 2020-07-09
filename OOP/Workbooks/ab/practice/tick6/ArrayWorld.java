
package ab.practice.tick6;

class ArrayWorld extends WorldImpl {

	private boolean[][] cells;

	public ArrayWorld(int w, int h) {
		super(w,h);
		cells = new boolean[h][w];
	}

	protected ArrayWorld(ArrayWorld prev) {
		super(prev);
		cells = new boolean[prev.getHeight()][prev.getWidth()];

	}

	public boolean getCell(int col, int row) {
		if (row < 0 || col < 0 || row > super.getHeight() - 1 || col > super.getWidth() - 1) return false;

		return cells[row][col];
	}

	public void setCell(int col, int row, boolean alive) {

		if (row < 0 || col < 0 || row > super.getHeight() - 1 || col > super.getWidth() - 1) return;

		cells[row][col] = alive;
	}

	protected ArrayWorld nextGeneration() {

		ArrayWorld world = new ArrayWorld(this);
   	
		for (int i = 0; i < super.getHeight(); i++) {
			for (int j = 0; j < super.getWidth(); j++) {
				world.setCell(j, i, computeCell(j, i));
			}
		}

		return world;

	}


}

