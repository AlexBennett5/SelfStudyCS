
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

public class SpringGuiFactory implements IGuiFactory {

	public JFrame createFrame() {

		JFrame frame = new JFrame("Spring View");
		return frame;
	}

	public JButton createButton() {

		JButton button = new JButton("It's spring!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Flowers are blooming!");
			}
		});
		Color col = Color.decode("#F8F8FF");
		button.setBackground(col);
		button.setOpaque(true);
		button.setBorderPainted(false);
		return button;

	}
	
	public JLabel createIcon() {

		ImageIcon icon = new ImageIcon(new ImageIcon("AbstractFactory/spring.jpg").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		Color col = Color.decode("#F0FFF0");
                label.setBackground(col);
		label.setOpaque(true);
		return label;

	}

}

