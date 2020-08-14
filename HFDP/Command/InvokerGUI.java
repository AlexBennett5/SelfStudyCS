
package Command;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvokerGUI {

	private Invoker invoke;

	public InvokerGUI(Light[] lights) {

		invoke = new Invoker();
		int k = 0;

		for (Light light : lights) {
	
			DimCommand dm = new DimCommand(light);
			BrightCommand br = new BrightCommand(light);
			CycleLeftCommand lf = new CycleLeftCommand(light);
			CycleRightCommand rg = new CycleRightCommand(light);

			invoke.setCommand(k++, dm, br);
			invoke.setCommand(k++, lf, rg);		

		}

	}

	public JFrame generateFrame() {

		JFrame frame = new JFrame("Remote Control");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(9, 2));
		addButtons(frame);
		

		return frame;

	}

	public void addButtons(JFrame frame) {

		int k = 1;

		for (int i = 0; i < 8; i++) {

			String lightName = "L" + k;
			JButton lbt = generateLeftButton("Dim", lightName, i);
			JButton rbt = generateRightButton("Brighten", lightName, i);
			i++;
			JButton clbt = generateLeftButton("Cycle Left", lightName, i);
			JButton crbt = generateRightButton("Cycle Right", lightName, i);
			k++;
		
			frame.add(lbt);
			frame.add(rbt);
			frame.add(clbt);
			frame.add(crbt);	
		}

		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.undoPressed();
			}
		});

		frame.add(undo);
	

	}

	public JButton generateLeftButton(String commandName, String lightName, int slot) {

		JButton bt = new JButton(commandName + " " + lightName);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.leftPressed(slot);
			}
		});

		return bt;

	}
	
	public JButton generateRightButton(String commandName, String lightName, int slot) {

		JButton bt = new JButton(commandName + " " + lightName);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.rightPressed(slot);
			}
		});

		return bt;

	}
}

