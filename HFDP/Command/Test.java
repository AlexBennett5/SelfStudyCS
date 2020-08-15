
package Command;

import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

	//Invoker only supports four lights

	public static void main(String[] args) {

		Light l1 = new Light(generateColors("#F0F8FF,#5F9EA0,#FA8072"));	
		Light l2 = new Light(generateColors("#00FFFF,#FFDEAD"));
		Light l3 = new Light(generateColors("#D8BFD8,#E6E6FA,#FF00FF"));
		Light l4 = new Light(generateColors("#FF7F50,#FFD700"));

		ArrayList<Light> lights = new ArrayList<Light>();
		Collections.addAll(lights, l1, l2, l3, l4);
		
		LightSystem sys = new LightSystem(lights);	
		displayGUI(sys);

	}

	public static ArrayList<Color> generateColors(String str) {

		ArrayList<Color> colors = new ArrayList<Color>();
		String[] colorStr = str.split(",");

		for (String colorName : colorStr) {
			colors.add(Color.decode(colorName));
		}

		return colors;
	}

	public static void displayGUI(LightSystem sys) {

		InvokerGUI invoke = sys.generateInvokerGUI();
		LightWindowGUI window = sys.generateLightWindowGUI();

		JFrame remote = invoke.generateFrame();
		JFrame lights = window.generateFrame();

		remote.setVisible(true);
		lights.setVisible(true);

	}
		

}

