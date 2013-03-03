package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;

public class Turtle extends Sprite {

    private boolean myPenDown = true;
    private boolean myTurtleShowing = true;
    private static final int CENTER_X_VALUE = 0;
    private static final int CENTER_Y_VALUE = 0;
    private List<Line> myLineList = new ArrayList<Line>();
    private Dimension myCanvasBounds;
    
    public Turtle (Pixmap image, Location center, Dimension size, Dimension canvasBounds) {
        super(image, center, size);
        myCanvasBounds = canvasBounds;
        
    }
    
    public int move (int pixels) {
        //TODO implement move with lines
        
        return pixels;
    }
    
    public double turn (double degrees) {
        setVelocity(getVelocity().getDirection() + degrees, 0);
        return degrees;
    }
    
    public double setHeading (double heading) {
        setVelocity(heading, 0);
        return heading;
    }
    
    public double towards (Location location) {
        double turnDistance = Vector.angleBetween(new Location(getX(), getY()), location);
        turn(turnDistance);
        return turnDistance;
    }
    
    public int setLocation (Location location) {
        //TODO implement move with lines
        return 0;
    }
    
    public int showTurtle () {
        myTurtleShowing = true;
        return 1;
    }
    
    public int hideTurtle () {
        myTurtleShowing = false;
        return 0;
    }
    
    public int showPen () {
        myPenDown = true;
        return 1;
    }
    
    public int hidePen () {
        myPenDown = false;
        return 0;
    }
    
    public int home () {
        // TODO change center to not be 0, 0
        Location center = new Location (0, 0);
        int distance = (int) Vector.distanceBetween(getLocation(), center);
        setLocation(center);
        setHeading(UP_DIRECTION);
        return distance;
    }
    
    public int clearScreen () {
        int distance = home();
        myLineList.clear();
        return distance;
    }
    
    public int isTurtleShowing () {
        if(myTurtleShowing) {
            return 1;
        }
        return 0;
    }
    
    public int isPenDown () {
        if(myPenDown) {
            return 1;
        }
        return 0;
    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        
    }
    
}
