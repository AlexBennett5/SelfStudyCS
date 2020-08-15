
package Command;

import java.awt.Color;
import java.util.ArrayList;

public class Light {

	private ArrayList<Color> colorCycle;
	private int currentColorIndex;
	private Color currentColor;
	
	private LightWindowGUI window;

	public Light(ArrayList<Color> colors) {

		colorCycle = colors;
		currentColorIndex = 0;
		currentColor = colorCycle.get(currentColorIndex);	

	}

	public void setWindow(LightWindowGUI window) {
		
		this.window = window;
	}

	public Color getColor() {
		
		return currentColor;
	}

	public void updateColor() {

		currentColor = colorCycle.get(currentColorIndex);
		notifyWindow();
	}

	private void notifyWindow() {

		window.update();
	}

	public void cycleLeft() {

		currentColorIndex = subtractModuloSize(currentColorIndex);
		updateColor();
	}

	private int subtractModuloSize(int n) {
		
		return (((n - 1) % colorCycle.size()) + colorCycle.size()) % colorCycle.size();
	}

	public void cycleRight() {

		currentColorIndex = addModuloSize(currentColorIndex);
		updateColor();

	}

	private int addModuloSize(int n) {

		return (n + 1) % colorCycle.size();
	}

	public void dim() {

		currentColor = currentColor.darker();
		notifyWindow();
	}

	public void brighten() {

		currentColor = currentColor.brighter();
		notifyWindow();
	}
}

