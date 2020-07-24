
package Ch2;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class SwingObserverExample {
	JFrame frame;

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	public void go() {
		frame = new JFrame();
		JButton button = new JButton("Should I do it?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setTitle("Choices, choices");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Don't do it!");
		}
	}

	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Come on, do it!");
		}
	}

}
