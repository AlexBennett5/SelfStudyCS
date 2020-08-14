
package Command;

import java.awt.Color;

public class Light {

	private String[] col;
	private int colorSize;
	private int currentColorIndex;
	private Color currentColor;

	private LightWindowGUI window;

	public Light(String[] colors) {

		String[] wht = {"#FFFFFF"};

		if (colors.length == 0) col = wht;
		else col = colors;

		colorSize = col.length;
		currentColorIndex = 0;

		currentColor = Color.decode(col[currentColorIndex]);

	}

	public void setWindow(LightWindowGUI window) {
		
		this.window = window;
	}	

	public void dim() {
		
		currentColor = currentColor.darker();
		notifyObserver();
	}

	public void brighten() {

		currentColor = currentColor.brighter();
		notifyObserver();
	}

	public void cycleLeft() {

		currentColorIndex = (((currentColorIndex - 1) % colorSize) + colorSize) % colorSize;
		currentColor = Color.decode(col[currentColorIndex]);
		notifyObserver();
	}
	
	public void cycleRight() {

		currentColorIndex = (currentColorIndex + 1) % colorSize;
		currentColor = Color.decode(col[currentColorIndex]);		
		notifyObserver();
	}

	public Color getColor() {

		return currentColor;
	}

	public void notifyObserver() {
		
		window.update();
	}

}

