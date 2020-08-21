
package src.main;

import java.awt.Color;

public class Square implements Shape {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	public Square(int x, int y, int width, int height, Color color) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
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
		this.x = x;
		this.y = y;
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

