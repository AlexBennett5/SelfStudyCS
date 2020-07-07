
package ab.practice.tick5;

class PackedWorld extends WorldImpl {

	private long cells;

	public PackedWorld() {
		super(8,8);
		cells = 0L;
	}

	protected PackedWorld(PackedWorld prev) {
		super(prev);
		cells = 0L;
	}

	public boolean getCell(int col, int row) {
		if (row < 0 || col < 0 || row > super.getHeight() - 1 || col > super.getWidth() - 1) return false;

		return ((1 & (cells >> (col + 8*row))) == 1);
	}


	public void setCell(int col, int row, boolean alive) {

		if (row < 0 || col < 0 || row > super.getHeight() - 1 || col > super.getWidth() - 1) return;

		if (alive) {
			cells = (cells | (1L << (col + 8*row)));
		} else {
			cells = (cells & ~(1L << (col + 8*row)));
		}
	}

	protected PackedWorld nextGeneration() {

		PackedWorld world = new PackedWorld(this);
   	
		for (int i = 0; i < super.getHeight(); i++) {
			for (int j = 0; j < super.getWidth(); j++) {
				world.setCell(j, i, computeCell(j, i));
			}
		}

		return world;

	}


}

