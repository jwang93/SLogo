package model;

import util.AbstractSprite;
import util.Keywords;
import util.Location;
import util.Vector;


public class Turtle extends AbstractSprite {

    private Location myCenter;
    private double myHeading;

    public Location getCenter () {
        return myCenter;
    }

    public void setCenter (Location myCenter) {
        this.myCenter = myCenter;
    }

    public Turtle () {
        // TODO Auto-generated constructor stub
    }

    public void translate (Vector v) {
        // TODO figure out how to move through edges of canvas
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double myHeading) {
        this.myHeading = myHeading;
    }
    
    public void turn () {
        myHeading = myHeading + Keywords.TURN_AROUND;
    }

}
