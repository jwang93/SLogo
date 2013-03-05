package model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import util.Location;
import util.Paintable;


  Represents all the line segments on a canvas. Can be painted.
  @author David Winegar
  @author Zhen Gou
 
 
public class Line implements Paintable {
	private ArrayListLineSegment myLineSegmentList;

    public Line () {
    	myLineSegmentList=new ArrayListLineSegment();
    }
    
    public void addLineSegment(Location currentLocation, Location nextLocation){
    	myLineSegmentList.add(new LineSegment(currentLocation,nextLocation));
    }
    
    public void clear(){
    	myLineSegmentList.clear();
    }
    
    @Override
    public void paint (Graphics2D pen) {
    	for (LineSegment ls myLineSegmentList){
    		ls.paint(pen);
    	}
    }

}