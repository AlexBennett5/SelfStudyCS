
package AbstractFactory;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public interface IGuiFactory {

	public JFrame createFrame();
	public JButton createButton();
	public JLabel createIcon();

}

