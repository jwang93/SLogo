package model;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Location;

public class Turtles implements ITurtle {

    Map<Integer, Turtle> turtles = new HashMap<Integer, Turtle>();
    
    public Turtles (Dimension canvasBounds) {
        turtles.put(1, new Turtle(canvasBounds));
    }

    @Override
    public int move (int pixels) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double turn (double degrees) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double setHeading (double heading) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double towards (Location location) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setLocation (Location location) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int showTurtle () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int hideTurtle () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int showPen () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int hidePen () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int home () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int clearScreen () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int isTurtleShowing () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int isPenDown () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getHeading () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Location getTurtlePosition () {
        // TODO Auto-generated method stub
        return null;
    }

}
