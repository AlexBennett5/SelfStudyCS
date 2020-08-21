package src.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DraggableComponent extends JComponent {

		private volatile int screenX = 0;
		private volatile int screenY = 0;
		private volatile int myX = 0;
		private volatile int myY = 0;

		public DraggableComponent(int xl, int yl, int xh, int yh) {

			setBorder(new LineBorder(Color.BLUE, 3));
			setBackground(Color.WHITE);
			setBounds(xl, yl, xh, yh);
			setOpaque(false);

			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {
					screenX = e.getXOnScreen();
					screenY = e.getYOnScreen();
					myX = getX();
					myY = getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}
			});

			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent e) {
					int deltaX = e.getXOnScreen() - screenX;
					int deltaY = e.getYOnScreen() - screenY;
					
					int newX = myX + deltaX;
					int newY = myY + deltaY;

					if (newX > 500) {
						newX = 500;
					} else if (newX <= 0) {
						newX = 0;
					}
					
					if (newY > 500) {
						newY = 500;
					} else if (newY <= 0) {
						newY = 0;
					}
					
					setLocation(newX, newY);
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});

		}

}

