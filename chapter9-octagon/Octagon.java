// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 9 - Octagon

import java.awt.Graphics;

public class Octagon implements Shape {

	public Octagon(int s) {
		this.s = s;
	}

	public double getArea() {
		return 2 * (1 + Math.sqrt(2)) * (s*s);
	}

  public double getPerimeter() {
    return 8 * s;
  }

  public void drawingPanel(int x, int y, Graphics g) {
    int a = (int)(s/Math.sqrt(2)),
        b = (int)(2 * s/Math.sqrt(2));
  	g.drawLine(x + a, y, x + a + s, y);
  	g.drawLine(x + a + s, y, x + b + s, y + a);
  	g.drawLine(x + b + s, y + a, x + b + s, y + a + s);
  	g.drawLine(x + b + s, y + a + s, x + a + s, y + s + b);
  	g.drawLine(x + a, y + b + s, x + a + s, y + s + b);
  	g.drawLine(x, y + a + s, x + a, y + b + s);
  	g.drawLine(x, y + a + s, x, y + a);
  	g.drawLine(x + a, y, x, y + a);
  }

  private int s; // Side length

}
