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
        moveRecursiveHelper(pixels);
        return pixels;
    }
    
    private void moveRecursiveHelper (int pixels) {
        if(pixels == 0){
            return;
        }
        double angle = getVelocity().getDirection();
        Location currentLocation = getLocation();
        Location nextLocation = getLocation();
        nextLocation.translate(new Vector(getVelocity().getDirection(), pixels));
        // top
        if(nextLocation.getY() < 0){
            nextLocation = new Location(getX() + getY()/Math.tan(angle), 0);
            setCenter(new Location(getX() + getY()/Math.tan(angle), myCanvasBounds.getHeight()));
        //bottom
        } else if(nextLocation.getY() > myCanvasBounds.getHeight()) {
            nextLocation = new Location(getX() + getY()/Math.tan(angle), myCanvasBounds.getHeight());   
            setCenter(new Location(getX() + getY()/Math.tan(angle), 0));
        //right
        } else if(nextLocation.getX() > myCanvasBounds.getWidth()) {
            nextLocation = new Location(myCanvasBounds.getWidth(), getY() + getX()/Math.tan(angle));
            setCenter(new Location(0, getY() + getX()/Math.tan(angle)));
        //left
        } else if(nextLocation.getX() < 0) {
            nextLocation = new Location(0, getY() + getX()/Math.tan(angle));
            setCenter(new Location(myCanvasBounds.getWidth(), getY() + getX()/Math.tan(angle)));
        } 
        

        pixels -= (int) Vector.distanceBetween(currentLocation, nextLocation) * Math.signum(pixels);
        
        addLine(currentLocation, nextLocation);
        
        moveRecursiveHelper(pixels);
    }
    
    private void addLine(Location loc1, Location loc2){
        if(myPenDown){
            myLineList.add(new Line(loc1, loc2));
        }
    }
    
    public double turn (double degrees) {
        setVelocity(getVelocity().getDirection() + degrees, 0);
        return degrees;
    }
    
    public double setHeading (double heading) {
        setVelocity(heading, 0);
        return heading;
    }
    
    //TODO change location coords
    public double towards (Location location) {
        double turnDistance = Vector.angleBetween(new Location(getX(), getY()), location);
        turn(turnDistance);
        return turnDistance;
    }
    
    //TODO change location coords
    public int setLocation (Location location) {
        double heading = getHeading();
        towards(location);
        int distance = (int) Vector.distanceBetween(location, getLocation());
        setHeading(heading);
        return distance;
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

    public double getHeading () {
        return getVelocity().getDirection();
    }
    
    @Override
    public void update (double elapsedTime, Dimension bounds) {
        
    }
    
}
