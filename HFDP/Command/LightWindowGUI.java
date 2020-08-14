
package Command;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class LightWindowGUI {

	private Light UL;
	private Light UR;
	private Light LL;
	private Light LR;

	private JLabel ULlab;
	private JLabel URlab;
	private JLabel LLlab;
	private JLabel LRlab;

	public LightWindowGUI(Light[] lights) {

		UL = lights[0];
		UR = lights[1];
		LL = lights[2];
		LR = lights[3];

		ULlab = new JLabel("Light 1");
		ULlab.setBackground(UL.getColor());
		ULlab.setOpaque(true);
		
		URlab = new JLabel("Light 2");
		URlab.setBackground(UR.getColor());
		URlab.setOpaque(true);
	
		LLlab = new JLabel("Light 3");
		LLlab.setBackground(LL.getColor());
		LLlab.setOpaque(true);
	
		LRlab = new JLabel("Light 4");
		LRlab.setBackground(LR.getColor());
		LRlab.setOpaque(true);
	}

	public void update() {

		ULlab.setBackground(UL.getColor());
		URlab.setBackground(UR.getColor());
		LLlab.setBackground(LL.getColor());
		LRlab.setBackground(LR.getColor());

	}

	public JFrame generateFrame() {

		JFrame frame = new JFrame("Light Window");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(2,2));
		frame.add(ULlab);
		frame.add(URlab);
		frame.add(LLlab);
		frame.add(LRlab);

		return frame;
		
	}
	

}

