// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 9 - Move a Box with JFrame

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class BoxMove extends JFrame implements MouseListener, MouseMotionListener {

  public static void main(String[] args) {
    new BoxMove();
  }

  public BoxMove() {
    setSize(500, 500);
    setVisible(true);
    setTitle("Drag the Box");
    addMouseListener(this);
    addMouseMotionListener(this);
    setBackground(BG_COLOR);

    insideBox = false;
    boxWidth = 80;
    boxHeight = 80;
    boxX = 200;
    boxY = 200;
  }

  public void paint(Graphics g) {
    g.setColor(BOX_COLOR);
    g.fillRect(boxX, boxY, boxWidth, boxHeight);
  }

  // When mouse is pressed, check if mouse is inside the box
  @Override
  public void mousePressed(MouseEvent arg0) {
    int mX = arg0.getX();
    int mY = arg0.getY();

    // Is mouse inside box?
    if (mX > boxX && mX < boxX + boxWidth) {
      if (mY > boxY && mY < boxY + boxHeight) {
        distanceX = mX - boxX;
        distanceY = mY - boxY;
        insideBox = true;
      }
    }
  }

  @Override
  public void mouseDragged(MouseEvent arg0) {
    int mX = arg0.getX();
    int mY = arg0.getY();
    Graphics g = this.getGraphics();

    // Redraw the window if mouse is inside the box
    if (insideBox) {
      g.setColor(BG_COLOR);
      g.fillRect(boxX, boxY, boxWidth, boxHeight);
      boxX = arg0.getX() - distanceX;
      boxY = arg0.getY() - distanceY;
      g.setColor(BOX_COLOR);
      g.fillRect(boxX, boxY, boxWidth, boxHeight);
    }
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    insideBox = false;
  }

  @Override public void mouseEntered(MouseEvent arg0) {}
  @Override public void mouseExited(MouseEvent arg0) {}
  @Override public void mouseMoved(MouseEvent arg0) {}
  @Override public void mouseClicked(MouseEvent arg0) {}

  private int boxWidth;
  private int boxHeight;
  private int boxX;
  private int boxY;
  private int distanceX; // Mouse Distance from Box X-Position
  private int distanceY; // Mouse Distance from Box Y-Position
  private boolean insideBox;
  private static final Color BOX_COLOR = Color.BLUE;
  private static final Color BG_COLOR = Color.WHITE;

}
