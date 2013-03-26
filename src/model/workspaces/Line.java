package model.workspaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import util.Location;
import util.Paintable;


/**
 * Represents all the line segments on a canvas. Can be painted.
 * 
 * all methods and constructors are protected except for paint(Graphics2D pen) because this is a
 * low-level class that is accessed through the ITurtle interface implemented in Workspace.
 * @author David Winegar
 * @author Zhen Gou
 */

public class Line implements Paintable {

    private ArrayList<LineSegment> myLineSegmentList = new ArrayList<LineSegment>();;

    /**
     * Adds a line segment to the line.
     * 
     * @param currentLocation first parameter for line segment
     * @param nextLocation second parameter for line segment
     */
    protected void addLineSegment (Location currentLocation, Location nextLocation) {
        myLineSegmentList.add(new LineSegment(currentLocation, nextLocation));
    }

    /**
     * Removes all line segments.
     */
    protected void clear () {
        myLineSegmentList.clear();
    }

    /**
     * paints all line segments.
     * 
     * @param pen to paint with
     */
    @Override
    public void paint (Graphics2D pen) {
        for (LineSegment ls : myLineSegmentList) {
            ls.paint(pen);
        }
    }

    /**
     * set pen color
     * 
     * @param color color of pen
     */
    protected void setPenColor (Color color) {
        for (LineSegment segment : myLineSegmentList) {
            segment.setPenColor(color);
        }
    }

    /**
     * set pen size
     * 
     * @param size pixels of width of pen
     */
    protected void setPenSize (int size) {
        for (LineSegment segment : myLineSegmentList) {
            segment.setPenSize(size);
        }
    }
}
