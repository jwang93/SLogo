package model;

import java.awt.Graphics2D;
import util.Location;
import util.Paintable;

/**
 * Represents a line on a canvas. Can be painted.
 * @author David Winegar
 *
 */
public class Line implements Paintable {

    private Location myStartLocation;
    private Location myEndLocation;
    
    public Line (Location start, Location end) {
        myStartLocation = start;
        myEndLocation = end;
    }
    
    @Override
    public void paint (Graphics2D pen) {
        pen.drawLine((int) myStartLocation.getX(), (int) myStartLocation.getY(), (int) myEndLocation.getX(), (int) myEndLocation.getY());
    }

}