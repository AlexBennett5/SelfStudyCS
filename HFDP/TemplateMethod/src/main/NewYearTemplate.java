
package src.main;

public class NewYearTemplate extends AbstractTemplate {

	private final String asciiArt = 
"|_|  .  |) |) \\./\n" +
"| | /-\\ |  |   |\n" +
"' ''   ''  '   '\n" +
" . .  _ |  |\n" +
" |\\| |- \\/\\/\n" +
" ' '  ~\n" +
"\\./  _  .  |)\n" +
" |  |- /-\\ |\\ \n" +
" '   ~'   '' '"; 
	
	public NewYearTemplate(User user) {
		super(user);
	}

	protected void printBorder() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

	@Override
	protected void printGraphic() {
		System.out.println(asciiArt);
	}

	@Override
	protected void printMessage() {
		System.out.println("HAPPY NEW YEAR");
	}
}

