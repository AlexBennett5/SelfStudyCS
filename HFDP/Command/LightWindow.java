
package Command;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class LightWindow {

	private Light UL;
	private Light UR;
	private Light LL;
	private Light LR;

	private JLabel ULlab;
	private JLabel URlab;
	private JLabel LLlab;
	private JLabel LRlab;

	public LightWindow(Light UL, Light UR, Light LL, Light LR) {

		this.UL = UL;
		this.UR = UR;
		this.LL = LL;
		this.LR = LR;

		ULlab = new JLabel();
		ULlab.setBackground(UL.getColor());
		UL.setOpaque();
		
		URlab = new JLabel();
		URlab.setBackground(UR.getColor());
		UR.setOpaque();
	
		LLlab = new JLabel();
		LLlab.setBackground(LL.getColor());
		LL.setOpaque();
	
		LRlab = new JLabel();
		LRlab.setBackground(LR.getColor());
		LR.setOpaque();
	}

	public void update() {

		ULlab.setBackground(UL.getColor());
		URlab.setBackground(UR.getColor());
		LLlab.setBackground(LL.getColor());
		LRlab.setBackground(LR.getColor());

	}

	public JFrame generateJFrame() {

		JFrame frame = new JFrame("Light Window");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(4,4));
		frame.add(ULlab);
		frame.add(URlab);
		frame.add(LLlab);
		frame.add(LRlab);

		return frame;
		
	}
	

}

