
package src.main;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DraggableShape extends JComponent implements Draggable{

	private Shape shape;

	public DraggableShape(Shape shape) {
		this.shape = shape;
		setBorder(new LineBorder(shape.getColor(), 3));
		setBackground(Color.WHITE);
		setBounds(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
		setOpaque(false);
		
	}

	public void updateLocation() {

		setLocation(shape.getX(), shape.getY());

	}



}

