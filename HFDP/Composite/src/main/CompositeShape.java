
package src.main;

import java.awt.Color;
import java.util.ArrayList;

public class CompositeShape implements Shape {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private ArrayList<Shape> shapes;
	private Draggable component;

	public CompositeShape(int x, int y, int width, int height, Color color) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;

		shapes = new ArrayList<Shape>();
	}

	public void addShape(Shape newShape) {
	
		newShape.move(x, y);

		for (Shape shape : shapes) {

			if (!newShape.isOutsideShapeX(shape)) {
				newShape.move(shape.getX() + shape.getWidth(), y);
			}
		}

		if (!newShape.isInsideCompositeShape(this)) {
			System.out.println("Not enough room for another shape");
		} else {
			shapes.add(newShape);
		}

	}

	public Shape currentShapeSelected(int x, int y) {

		for (Shape shape : shapes) {

			if (x >= shape.getX() && x <= shape.getX() + shape.getWidth() && y >= shape.getY() && y <= shape.getY() + shape.getHeight()) {
				return shape;
			}

		}

		return this;

	}

	public void setDraggable(Draggable component) {
		this.component = component;
	}

	public void notifyDraggable() {
		component.updateLocation();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}

	public void move(int x, int y) {
		
		int deltaX = x - this.x;
		int deltaY = y - this.y;

		for (Shape shape : shapes) {

			shape.move(shape.getX() + deltaX, shape.getY() + deltaY);
		}
		
		this.x = x;
		this.y = y;
		notifyDraggable();
	}

	public boolean isOutsideShapeX(Shape shape) {
		return ((getX() + getWidth()) <= shape.getX()) || (getX() >= (shape.getX() + shape.getWidth())); 
	}
		
	public boolean isOutsideShapeY(Shape shape) {
		return (getY() <= (shape.getY() + shape.getHeight()) || ((getY() + getHeight()) >= shape.getY()); 
	}
	
	public boolean isInsideCompositeShapeX(CompositeShape shape) {
		return (getX() >= shape.getX()) && (getX() + getWidth() <= shape.getX() + shape.getWidth());
	}
	
	public boolean isInsideCompositeShapeY(CompositeShape shape) {	
		return (getY() >= shape.getY()) && (getY() + getHeight() <= shape.getY() + shape.getHeight());
	}

}

