package model;

import java.awt.Color;
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
	private static final Color DEFAULT_COLOR=Color.black;
    private static final int DEFAULT_PEN_SIZE=2;
	
    private ArrayList<LineSegment> myLineSegmentList;
    private Color myColor=Color.red;
    
    private int mySize;

    /**
     * Creates a list of line segments that form a single line.
     */
    public Line () {
        myLineSegmentList = new ArrayList<LineSegment>();
        mySize=DEFAULT_PEN_SIZE;
        myColor=DEFAULT_COLOR;
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
     * 
     * @param pen to paint with
     */
    @Override
    public void paint (Graphics2D pen) {
    	pen.setColor(myColor);
	
        for (LineSegment ls : myLineSegmentList) {
        	ls.setPenSize(mySize);
            ls.paint(pen);
        }
    }
    
    /**
     * set pen color
     * 
     */
    public void setPenColor(Color color){
    	myColor=color;
    }
    
    /**
     * set pen size
     * 
     */
    public void setPenSize(int size){
    	mySize=size;
    }
}
