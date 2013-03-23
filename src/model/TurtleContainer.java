package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import util.Location;
import util.Paintable;


public class TurtleContainer implements ITurtle {

    Map<Integer, Turtle> myTurtles = new HashMap<Integer, Turtle>();
    List<Turtle> myActiveTurtles = new ArrayList<Turtle>();
    Dimension currentDimension;

    public TurtleContainer (Dimension canvasBounds) {
        Turtle firstTurtle = new Turtle(canvasBounds);
        myTurtles.put(1, firstTurtle);
        myActiveTurtles.add(firstTurtle);
        currentDimension = canvasBounds;
    }

    private List<Turtle> getActiveTurtles () {
        return myActiveTurtles;
    }

    @Override
    public int move (int pixels) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.move(pixels);
        }
        return i;
    }

    @Override
    public double turn (double degrees) {
        double i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.turn(degrees);
        }
        return i;
    }

    @Override
    public double setHeading (double heading) {
        double i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.setHeading(heading);
        }
        return i;
    }

    @Override
    public double towards (Location location) {
        double i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.towards(location);
        }
        return i;
    }

    @Override
    public int setLocation (Location location) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.setLocation(location);
        }
        return i;
    }

    @Override
    public int showTurtle () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.showTurtle();
        }
        return i;
    }

    @Override
    public int hideTurtle () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.hideTurtle();
        }
        return i;
    }

    @Override
    public int showPen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.showPen();
        }
        return i;
    }

    @Override
    public int hidePen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.hidePen();
        }
        return i;
    }

    @Override
    public int home () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.home();
        }
        return i;
    }

    @Override
    public int clearScreen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.clearScreen();
        }
        return i;
    }

    @Override
    public int isTurtleShowing () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.isTurtleShowing();
        }
        return i;
    }

    @Override
    public int isPenDown () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.isPenDown();
        }
        return i;
    }

    @Override
    public double getHeading () {
        double i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.getHeading();
        }
        return i;
    }

    @Override
    public Location getTurtlePosition () {
        Location i = null;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.getTurtlePosition();
        }
        return i;
    }

    @Override
    public Iterator<Paintable> getPaintableIterator () {
        return getActiveTurtles().get(getActiveTurtles().size() - 1).getPaintableIterator();
    }

    @Override
    public int setBackgroundColor (int colorIndex) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setBackgroundImage (int imageIndex) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setPenColor (int colorIndex) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setPenSize (int pixels) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setShape (int shapeIndex) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setPalette (int colorIndex, int red, int green, int blue) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPenColor () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int stamp () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int clearStamps () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getShapeIndex () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getTurtleID () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setActiveTurtles (int[] turtleIds) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void resetActiveTurtles () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int makeEvenTurtlesActive () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int makeOddTurtlesActive () {
        // TODO Auto-generated method stub
        return 0;
    }

}
