package model.workspaces;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import util.Location;
import util.Paintable;


/**
 * Represents a line segment on a canvas. Can be painted.
 * 
 * all methods and constructors are protected except for paint(Graphics2D pen) because this is a
 * low-level class that is accessed through the ITurtle interface implemented in Workspace.
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
    protected LineSegment (Location start, Location end) {
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
    protected void setPenSize (int size) {
        mySize = size;
    }

    /**
     * Sets pen color
     * @param color of lines
     */
    protected void setPenColor (Color color) {
        myColor = color;
    }

}
