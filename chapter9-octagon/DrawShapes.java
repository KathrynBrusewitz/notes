// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 9 - Octagon

import java.awt.Graphics;

public class DrawShapes {

    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics graphics = panel.getGraphics();

        Octagon octagon = new Octagon(40);
        octagon.drawingPanel(40, 40, graphics);

        System.out.println("Perimeter: " + octagon.getPerimeter());
        System.out.println("Area: " + octagon.getArea());

    }

}
