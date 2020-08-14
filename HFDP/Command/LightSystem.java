
package Command;

import javax.swing.JFrame;

public class LightSystem {

	private InvokerGUI invoke;
	private LightWindowGUI window;

	public LightSystem(String[][] colors) {

		Light[] lights = {new Light(colors[0]), new Light(colors[1]), new Light(colors[2]), new Light(colors[3])};

		invoke = new InvokerGUI(lights);
		window = new LightWindowGUI(lights);

		lights[0].setWindow(window);
		lights[1].setWindow(window);
		lights[2].setWindow(window);
		lights[3].setWindow(window);
	}

	public void displaySystem() {

		JFrame lights = window.generateFrame();
		JFrame remote = invoke.generateFrame();

		lights.setVisible(true);
		remote.setVisible(true);

	}

}

