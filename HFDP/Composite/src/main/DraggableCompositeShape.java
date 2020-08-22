
package src.main;

public class DraggableCompositeShape extends JComponent implements Draggable {

	private CompositeShape shapes;
	private Shape selected;
	private volatile screenX = 0;
	private volatile screenY = 0;

	public DraggableShape(CompositeShape shapes) {

		this.shapes = shapes;
		setBorder(new LineBorder(shapes.getColor(), 3));
		setBackground(Color.WHITE);
		setBounds(shapes.getX(), shapes.getY(), shapes.getWidth(), shapes.getHeight());
		setOpaque(false);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();
				selected = shapes.currentShapeSelected(screenX, screenY);	
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

				int newX = selected.getX() + deltaX;
				int newY = selected.getY() + deltaY;

				for (Shape shape : shapes) {

					//Redo outside/inside shape methods	

				}	

			}

			@Override
			public void mouseMoved(MouseEvent e) {}
	
		});
		
	}

	public void updateLocation() {

		setLocation(shape.getX(), shape.getY());

	}



}

