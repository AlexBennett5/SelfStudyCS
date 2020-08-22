
package src.main;

import java.awt.Color;

public class Circle implements Shape {

	private int x;
	private int y;
	private int radius;
	private Color color;
	private Draggable component;

	public Circle(int x, int y, int radius, Color color) {

		this.x = x;
		this.y = y;
		this.radius = radius;;
		this.color = color;
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
		return radius*2;
	}

	public int getHeight() {
		return radius*2;
	}

	public Color getColor() {
		return color;
	}

	public void move(int x, int y) {
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

