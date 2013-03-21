package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import util.Location;
import util.Paintable;

public class Turtles implements ITurtle {

    Map<Integer, Turtle> myTurtles = new HashMap<Integer, Turtle>();
    List<Turtle> myActiveTurtles = new ArrayList<Turtle>();
    
    public Turtles (Dimension canvasBounds) {
        Turtle firstTurtle = new Turtle(canvasBounds);
        myTurtles.put(1, firstTurtle);
        myActiveTurtles.add(firstTurtle);
    }
    
    private List<Turtle> getActiveTurtles() {
        return myActiveTurtles;
    }

    @Override
    public int move (int pixels) {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.move(pixels);
        }
        return i;
    }

    @Override
    public double turn (double degrees) {
        double i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.turn(degrees);
        }
        return i;
    }

    @Override
    public double setHeading (double heading) {
        double i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.setHeading(heading);
        }
        return i;
    }

    @Override
    public double towards (Location location) {
        double i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.towards(location);
        }
        return i;
    }

    @Override
    public int setLocation (Location location) {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.setLocation(location);
        }
        return i;
    }

    @Override
    public int showTurtle () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.showTurtle();
        }
        return i;
    }

    @Override
    public int hideTurtle () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.hideTurtle();
        }
        return i;
    }

    @Override
    public int showPen () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.showPen();
        }
        return i;
    }

    @Override
    public int hidePen () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.hidePen();
        }
        return i;
    }

    @Override
    public int home () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.home();
        }
        return i;
    }

    @Override
    public int clearScreen () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.clearScreen();
        }
        return i;
    }

    @Override
    public int isTurtleShowing () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.isTurtleShowing();
        }
        return i;
    }

    @Override
    public int isPenDown () {
        int i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.isPenDown();
        }
        return i;
    }

    @Override
    public double getHeading () {
        double i = 0;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.getHeading();
        }
        return i;
    }

    @Override
    public Location getTurtlePosition () {
        Location i = null;
        for(Turtle turtle : getActiveTurtles()) {
            i = turtle.getTurtlePosition();
        }
        return i;
    }

    public Iterator<Paintable> getPaintableIterator () {
        return getActiveTurtles().get(getActiveTurtles().size() - 1).getPaintableIterator();
    }

}
