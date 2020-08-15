
package Command;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.ArrayList;

public class LightWindowGUI {

	private ArrayList<Light> lights;
	private ArrayList<JLabel> labels;	

	public LightWindowGUI() {

		lights = new ArrayList<Light>();
		labels = new ArrayList<JLabel>();

	}

	public void addLight(Light lgt) {

		lights.add(lgt);
		labels.add(createLabel(lgt));

	}

	public JLabel createLabel(Light lgt) {

		JLabel label = new JLabel("Light " + currentLightNumber());
		label.setBackground(lgt.getColor());
		label.setOpaque(true);
		return label;

	}

	private int currentLightNumber() {

		return lights.size();

	}

	public void update() {

		for (int i = 0; i < lights.size(); i++) {

			Color newColor = lights.get(i).getColor();
			labels.get(i).setBackground(newColor);

		}	

	}

	public JFrame generateFrame() {

		JFrame frame = new JFrame("Light Window");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int gridSize = lights.size()/2;

		frame.setLayout(new GridLayout(gridSize, gridSize));
		addLabelsToFrame(frame);	

		return frame;
		
	}

	private void addLabelsToFrame(JFrame frame) {

		for (JLabel label : labels) {

			frame.add(label);
		}

	}
	
}

