
package ab.practice.tick4star;

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

	public Pattern(String format) throws PatternFormatException {


		try {

			String[] arr = format.split(":");
                	name = arr[0];
			author = arr[1];
			
			try {

				width = Integer.parseInt(arr[2]);
			
			} catch (NumberFormatException ex) {

				throw new PatternFormatException("width", arr[2]);

			}
				
			try {
				
				height = Integer.parseInt(arr[3]);
                	
			} catch (NumberFormatException ex) {

				throw new PatternFormatException("height", arr[3]);

			}

			try {

				startCol = Integer.parseInt(arr[4]);
			
			} catch (NumberFormatException ex) {

				throw new PatternFormatException("starting column", arr[4]);

			}
			
			try {

				startRow  = Integer.parseInt(arr[5]);
			
			} catch (NumberFormatException ex) {

				throw new PatternFormatException("starting row", arr[5]);
			}
			
			cells = arr[6];
		
		} catch (ArrayIndexOutOfBoundsException ex) {

			throw new PatternFormatException(format);

		}

               
	}

	public void initialise(boolean[][] world) throws PatternFormatException {

                String[] config = cells.split(" ");

                for (int i = 0; i < config.length; i++) {

                        char[] values = config[i].toCharArray();

                        for (int j = 0; j < values.length; j++) {

                                if (values[j] == '1') {
                                        StatisticsLife.setCell(world, startCol + j, startRow + i, true);
                                }

				if (values[j] != '1' && values[j] != '0') {
					throw new PatternFormatException(i, j);
				}


			}
                }
        }


	

}
