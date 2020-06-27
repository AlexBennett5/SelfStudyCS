
package ab.practice.tick3star;

public class Pattern {

	private String name;
	private String author;
	private int width;
	private int height;
	private int startCol;
	private int startRow;
	private String cells;

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getStartCol() {
		return startCol;
	}

	public int getStartRow() {
		return startRow;
	}

	public String getCells() {
		return cells;
	}

	public Pattern(String format) {

		String[] arr = format.split(":");
                name = arr[0];
		author = arr[1];
		width = Integer.parseInt(arr[2]);
                height = Integer.parseInt(arr[3]);
                startCol = Integer.parseInt(arr[4]);
                startRow  = Integer.parseInt(arr[5]);
		cells = arr[6];
               
	}

	public void initialise(boolean[][] world) {

                String[] config = cells.split(" ");

                for (int i = 0; i < config.length; i++) {

                        char[] values = config[i].toCharArray();

                        for (int j = 0; j < values.length; j++) {

                                if (values[j] == '1') {
                                        AnimatedLife.setCell(world, startCol + j, startRow + i, true);
                                }
                        }
                }


	}

}
