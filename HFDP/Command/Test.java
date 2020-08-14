
package Command;

import javax.swing.JFrame;

public class Test {

	//Program accepts input of the form "#FFFFF,#FFFFF/#FFFFFF/#FFFFFF/#FFFFFF,#FFFFFF"
	//where '/' delineates each light color cycle

	public static void main(String[] args) {

		String colors = "#F0F8FF,#5F9EA0,#FA8072/#00FFFF,#FFDEAD/#D8BFD8,#E6E6FA,#FF00FF/#FF7F50,#FFD700";
		String[][] lights = parseArg(colors);
		
		LightSystem sys = new LightSystem(lights);
		sys.displaySystem();


	}

	public static String[][] parseArg(String arg) {

		String[] colors = arg.split("/");

		String[] l1 = colors[0].split(",");
		String[] l2 = colors[1].split(",");
		String[] l3 = colors[2].split(",");
		String[] l4 = colors[3].split(",");
	
		return new String[][] {l1, l2, l3, l4};
	}

}

