
package Command;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvokerGUI {

	private Invoker invoke;

	public InvokerGUI(Invoker invoke) {

		this.invoke = invoke;
	}

	public JFrame generateFrame() {

		JFrame frame = new JFrame("Remote Control");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(9, 2));
		addButtons(frame);

		return frame;

	}

	private void addButtons(JFrame frame) {

		for (int i = 0, k = 1; i < 8; i++, k++) {

			String lightName = "L" + k;
			addDimBrightPair(frame, lightName, i++);
			addCyclePair(frame, lightName, i);
		}

		addUndoButton(frame);

	}

	private void addDimBrightPair(JFrame frame, String lightName, int slot) {

		JButton dim = generateLeftButton("Dim", lightName, slot);
		JButton bright = generateRightButton("Brighten", lightName, slot);

		frame.add(dim);
		frame.add(bright);

	}

	private void addCyclePair(JFrame frame, String lightName, int slot) {

		JButton cycleLeft = generateLeftButton("Cycle Left", lightName, slot);
		JButton cycleRight = generateRightButton("Cycle Right", lightName, slot);

		frame.add(cycleLeft);
		frame.add(cycleRight);

	}


	private JButton generateLeftButton(String commandName, String lightName, int slot) {

		JButton bt = new JButton(commandName + " " + lightName);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.leftPressed(slot);
			}
		});

		return bt;

	}
	
	private JButton generateRightButton(String commandName, String lightName, int slot) {

		JButton bt = new JButton(commandName + " " + lightName);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.rightPressed(slot);
			}
		});

		return bt;

	}

	private void addUndoButton(JFrame frame) {

		JButton bt = new JButton("Undo");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke.undoPressed();
			}
		});

		frame.add(bt);

	}
}

