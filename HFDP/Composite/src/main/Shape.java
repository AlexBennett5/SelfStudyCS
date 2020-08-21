
package src.main;

import java.awt.Graphics;

public interface Shape {

	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public void move(int x, int y);
	public boolean isOutsideShapeX(Shape shape);
	public boolean isOutsideShapeY(Shape shape);
	public boolean isInsideCompositeShapeX(CompositeShape shape);
	public boolean isInsideCompositeShapeY(CompositeShape shape);
}

