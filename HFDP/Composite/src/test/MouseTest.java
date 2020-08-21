
package src.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MouseTest {

	public static void main(String[] args) {

		JFrame f = new JFrame("Test");
		f.setLayout(null);

		DraggableComponent dc = new DraggableComponent(0, 0, 100, 100);
		f.add(dc);

		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);

	}

}

