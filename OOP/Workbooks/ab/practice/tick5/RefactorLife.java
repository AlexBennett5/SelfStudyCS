
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

	private static List<Pattern> loadPatlist(String[] args, int index) {
	
		List<Pattern> patlist = new LinkedList<Pattern>();

		if (args[index].startsWith("http://") || args[index].startsWith("https://")) {
				
			try {
				patlist = PatternLoader.loadFromURL(args[index]);
			} catch (IOException ex) {
				System.out.println("An error occured when loading the patterns from a URL");
			} catch (PatternFormatException ex) {

			}

		} else {

			try {
				patlist = PatternLoader.loadFromDisk(args[index]);
			} catch (IOException ex) {
				System.out.println("An error occured when loading the patterns from a file");
			} catch (PatternFormatException ex) {

			}
		}

		return patlist;

	}

	public static void main(String[] args) throws Exception {

	
		try {

			String worldType = args.length == 3 ? args[0] : "--array";
			List<Pattern> patlist = new LinkedList<Pattern>();;

			if (args.length == 3) {
				patlist = loadPatlist(args, 1);
			} else if (args.length == 2 || args.length == 1) {
				patlist = loadPatlist(args, 0);
			}
			
			//Print contents only
			if (args.length == 1) {

				int index = 0;

				for (Pattern p : patlist) {
					System.out.println(index + ") " + p.getName() + ":" + p.getAuthor() + ":" + p.getWidth() + ":" + p.getHeight() + ":" + p.getStartCol() + ":" + p.getStartRow() + ":" + p.getCells());
					index++;
				}

			//Display game	
			} else {

				int index = -1;
				
				if (args.length == 3) {
					index = Integer.parseInt(args[2]);
				} else {
					index = Integer.parseInt(args[1]);
				}

				Pattern p = patlist.get(index);
				World w = null;
				
				if (worldType.equals("--array")) {
					w = new ArrayWorld(p.getWidth(), p.getHeight());
				} else if (worldType.equals("--long")) {
					w = new PackedWorld();
				} else if (worldType.equals("--aging")) {
					w = new AgingWorld(p.getWidth(), p.getHeight());
				} else {
					System.out.println("Invalid world type");
				}

				
				p.initialise(w);
				play(w);
				

			}
				


		} catch (ArrayIndexOutOfBoundsException ex) {

			System.out.println("Error: Invalid # of arguments. Input can be URL/textfile or URL/textfile & index number, nothing more");

		} catch (IndexOutOfBoundsException ex) {

			System.out.println("Error: invalid index");

		} catch (NumberFormatException ex) {

			System.out.println("Error: The trailing argument must be an integer value. Instead it was");
		
		} catch (PatternFormatException ex) {

	
		} 
	
	
	}

}

