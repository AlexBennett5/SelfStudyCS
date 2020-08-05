
package AbstractFactory;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SummerGuiFactory implements IGuiFactory {

	public JFrame createFrame() {

		JFrame frame = new JFrame("Summer View");
		return frame;
	}

	public JButton createButton() {

		JButton button = new JButton("It's summer!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "It's hot out!");
			}
		});
		Color col = Color.decode("#AFEEEE");
		button.setBackground(col);
		button.setOpaque(true);
		button.setBorderPainted(false);
		return button;

	}
	
	public JLabel createIcon() {

		ImageIcon icon = new ImageIcon(new ImageIcon("AbstractFactory/summer.jpg").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));;
		JLabel label = new JLabel(icon);
		Color col = Color.decode("#FFB6C1");
                label.setBackground(col);
		label.setOpaque(true);
		return label;

	}

}

