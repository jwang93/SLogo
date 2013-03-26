package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import util.Location;
import util.Paintable;


/**
 * Represents a line segment on a canvas. Can be painted.
 * 
 * @author David Winegar
 * @author Zhen Gou
 * 
 */

public class LineSegment implements Paintable {

    private static final Color DEFAULT_COLOR = Color.black;
    private static final int DEFAULT_PEN_SIZE = 2;
    private Location myStartLocation;
    private Location myEndLocation;
    private int mySize = DEFAULT_PEN_SIZE;
    private Color myColor = DEFAULT_COLOR;

    /**
     * Creates line segment from one location to the other.
     * 
     * @param start start of line.
     * @param end end of line.
     */
    public LineSegment (Location start, Location end) {
        myStartLocation = start;
        myEndLocation = end;
    }

    /**
     * Paints the line to the screen. Implements paintable.
     * 
     * @param pen to paint with
     */
    @Override
    public void paint (Graphics2D pen) {
        pen.setStroke(new BasicStroke(mySize));
        pen.setColor(myColor);
        pen.drawLine((int) myStartLocation.getX(), (int) myStartLocation.getY(),
                     (int) myEndLocation.getX(), (int) myEndLocation.getY());
    }

    /**
     * Sets the pen size to the size given
     * @param size of stroke in pixels
     */
    public void setPenSize (int size) {
        mySize = size;
    }

    /**
     * Sets pen color
     * @param color of lines
     */
    public void setPenColor (Color color) {
        myColor = color;
    }

}
