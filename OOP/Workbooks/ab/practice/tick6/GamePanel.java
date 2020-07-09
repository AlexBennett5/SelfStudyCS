
package ab.practice.tick6;

public class GamePanel extends JPanel {

	private int zoom = 10; //Number of pixels used to represent a cell
 	private int width = 1; //Width of game board in pixels
 	private int height = 1;//Height of game board in pixels
 	private World current = null;

 	public Dimension getPreferredSize() {
  		return new Dimension(width, height);
 	}

	protected void paintComponent(Graphics g) {

		if (current == null) return;
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(0,0,width,height);
		current.draw(g,width,height);
		if (zoom > 4) {
			g.setColor(java.awt.Color.LIGHT_GRAY);
			//TODO

		}

	}

}

