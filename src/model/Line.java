package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import util.Location;
import util.Paintable;


/**
 * Represents all the line segments on a canvas. Can be painted.
 * 
 * @author David Winegar
 * @author Zhen Gou
 */

public class Line implements Paintable {
    private ArrayList<LineSegment> myLineSegmentList;

    /**
     * Creates a list of line segments that form a single line.
     */
    public Line () {
        myLineSegmentList = new ArrayList<LineSegment>();
    }

    /**
     * Adds a line segment to the line.
     * 
     * @param currentLocation first parameter for line segment
     * @param nextLocation second parameter for line segment
     */
    public void addLineSegment (Location currentLocation, Location nextLocation) {
        myLineSegmentList.add(new LineSegment(currentLocation, nextLocation));
    }

    /**
     * Removes all line segments.
     */
    public void clear () {
        myLineSegmentList.clear();
    }

    /**
     * paints all line segments.
     * @param pen to paint with
     */
    @Override
    public void paint (Graphics2D pen) {
        for (LineSegment ls : myLineSegmentList) {
            ls.paint(pen);
        }
    }
}
