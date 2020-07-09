
package ab.practice.tick6;

import java.io.IOException;

public class CommandLineOptions {

	public static String WORLD_TYPE_LONG = "--long";
	public static String WORLD_TYPE_AGING = "--aging";
	public static String WORLD_TYPE_ARRAY = "--array";
	private String worldType = null;
	private Integer index = null;
	private String source = null;

	public CommandLineOptions(String[] args) throws CommandLineException {

		if (args.length == 3) {
			
			if (!(args[0].equals(WORLD_TYPE_LONG) || args[0].equals(WORLD_TYPE_AGING) || args[0].equals(WORLD_TYPE_ARRAY))) {
				throw new CommandLineException("Invalid storage type. Must be either --long, --array, or --aging");
			}

			worldType = args[0];
			source = args[1];

			try {
				index = Integer.parseInt(args[2]);
			
			} catch (NumberFormatException ex) {
				throw new CommandLineException("Error: index value must be integer");
			}

			if (index < 0) {
				throw new CommandLineException("Error: negative index value");
			}

		} else if (args.length == 2) {	

			worldType = WORLD_TYPE_ARRAY;
			source = args[0];

			try {
				index = Integer.parseInt(args[1]);
			
			} catch (NumberFormatException ex) {
				throw new CommandLineException("Error: index value must be integer");
			}

			if (index < 0) {
				throw new CommandLineException("Error: negative index value");
			}

		} else if (args.length == 1) {

			worldType = WORLD_TYPE_ARRAY;
			source = args[0];

		} else {

			throw new CommandLineException("Invalid number of arguments. Argument can be '[storage option] [source] [index]'");

		}

		

	}

	public String getWorldType() { return worldType; }
	public Integer getIndex() { return index; }
	public String getSource() { return source; }

}

