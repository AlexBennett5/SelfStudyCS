
package AbstractFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Test {

	public static void main(String[] args) {

		IGuiFactory fact = new SpringGuiFactory();

		if (args[0].equals("spring")) {
			fact = new SpringGuiFactory();
		} else if (args[0].equals("summer")) {
			fact = new SummerGuiFactory();
		} else if (args[0].equals("fall")) {
			fact = new FallGuiFactory();
		} else if (args[0].equals("winter")) {
			fact = new WinterGuiFactory();
		} else {
			System.out.println("Invalid season type");
			System.exit(1);
		}

		assembleWindow(fact);


	}

	public static void assembleWindow(IGuiFactory fact) {

		JFrame frame = fact.createFrame();
		frame.setSize(600, 400);
		
		JButton button = fact.createButton();
		JLabel label = fact.createIcon();

		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

