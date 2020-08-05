
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

public class WinterGuiFactory implements IGuiFactory {

	public JFrame createFrame() {

		JFrame frame = new JFrame("Winter View");
		return frame;
	}

	public JButton createButton() {

		JButton button = new JButton("It's winter!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Happy holidays!");
			}
		});
		Color col = Color.decode("#3CB371");
		button.setBackground(col);
		button.setOpaque(true);
		button.setBorderPainted(false);
		return button;

	}
	
	public JLabel createIcon() {

		ImageIcon icon = new ImageIcon(new ImageIcon("AbstractFactory/snowflake.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		Color col = Color.decode("#DC143C");
		label.setBackground(col);
		label.setOpaque(true);
		return label;

	}

}

