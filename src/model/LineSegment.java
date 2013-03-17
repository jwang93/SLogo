package model;

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

    private Location myStartLocation;
    private Location myEndLocation;

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
        pen.drawLine((int) myStartLocation.getX(), (int) myStartLocation.getY(),
                     (int) myEndLocation.getX(), (int) myEndLocation.getY());
    }

}
