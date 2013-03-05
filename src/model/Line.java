package model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import util.Location;
import util.Paintable;

/**
 * Represents a line on a canvas. Can be painted.
 * @author David Winegar
 *
 */
public class Line implements Paintable {
	private ArrayList<LineSegment> myLineSegmentList;

    public Line () {
    	myLineSegmentList=new ArrayList<LineSegment>();
    }
    
    public void addLineSegment(Location currentLocation, Location nextLocation){
    	myLineSegmentList.add(new LineSegment(currentLocation,nextLocation));
    }
    
    public void clear(){
    	myLineSegmentList.clear();
    }
    
    @Override
    public void paint (Graphics2D pen) {
    	for (LineSegment ls: myLineSegmentList){
    		ls.paint(pen);
    	}
    }

}