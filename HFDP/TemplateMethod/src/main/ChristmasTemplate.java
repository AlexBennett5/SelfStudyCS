
package src.main;

public class ChristmasTemplate extends AbstractTemplate {

	private final String asciiArt = 
"    ...        *                        *       * \n" + 
"       ...   *         * ..   ...                        *\n" + 
"*      ...        *           *            *\n" +
"          ...               ...                          *\n" +
"            ..                            *\n" +
"    *        ..        *                       *\n" +
"           __##____              *                      *\n" +
"  *    *  /  ##  ****                   *\n" +
"         /        ****               *         *  X   *\n" +
"   *    /        ******     *                    XXX      *\n" +
"       /___________*****          *             XXXXX \n" +
"        |            ***               *       XXXXXXX   X\n" +
"    *   | ___        |                    *   XXXXXXXX  XXX\n" +
"  *     | | |   ___  | *       *             XXXXXXXXXXXXXXX\n" +
"        | |_|   | |  ****             *           X   XXXXXXX\n" +
"    *********** | | *******      *                X      X\n" +
"************************************************************";

	public ChristmasTemplate(User user) {
		super(user);
	}

	protected void printBorder() {
		System.out.println("*************************************");
	}

	@Override
	protected void printGraphic() {
		System.out.println(asciiArt);
	}

	@Override
	protected void printMessage() {
		System.out.println("MERRY CHRISTMAS");
	}
}

