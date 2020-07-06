
package ab.practice.tick5;

import java.util.List;
import java.util.LinkedList;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class RefactorLife {

	public static void play(World w) throws Exception {
		int userResponse = 0;
		Writer wrt = new OutputStreamWriter(System.out);

		while (userResponse != 'q') {
			w.print(wrt);
			userResponse = System.in.read();
			w = w.nextGeneration(0);
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
					World w = new TestArrayWorld(p.getWidth(), p.getHeight());
					p.initialise(w);
					play(w);
				
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

