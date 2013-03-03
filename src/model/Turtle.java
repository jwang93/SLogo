package model;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;

public class Turtle extends Sprite {

    private boolean myPenDown = true;
    private boolean myTurtleShowing = true;
    
    public Turtle (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        
    }
    
    public int move (int pixels) {
        //TODO implement move with lines
        return pixels;
    }
    
    public int turn (int degrees) {
        setVelocity(getVelocity().getDirection() + degrees, 0);
        return degrees;
    }
    
    public void setHeading (int heading) {
        setVelocity(heading, 0);
    }
    
    public void towards (Location location) {
        setVelocity(Vector.angleBetween(new Location(getX(), getY()), location) , 0);
    }
    
    public void setLocation (Location location) {
        //TODO implement move with lines
    }
    
    public void toggleShowTurtle () {
        myTurtleShowing = !myTurtleShowing;
    }
    
    public void togglePen () {
        myPenDown = !myPenDown;
    }
    
    public void home () {
        setLocation(new Location (0, 0));
        setHeading(UP_DIRECTION);
    }
    
    public void clearScreen () {
        home();
        //TODO delete lines
    }
    
    public boolean isTurtleShowing () {
        return myTurtleShowing;
    }
    
    public boolean isPenDown () {
        return myPenDown;
    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        
    }
}
