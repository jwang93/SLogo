package model.workspaces;

import java.awt.Color;
import java.awt.Graphics2D;
import util.Location;
import util.Paintable;


/**
 * Creates a box around the current turtle (highlighter)
 * 
 * all methods and constructors are protected except for paint(Graphics2D pen) because this is a
 * low-level class that is accessed through the ITurtle interface implemented in Workspace.
 * @author Zhen Gou
 * 
 */
public class TurtleHighlighter implements Paintable {
    private Location myTopLeft;
    private Location myTopRight;
    private Location myBottomLeft;
    private Location myBottomRight;
    private Turtle myTurtle;

    /**
     * Makes a highlighter of the current turtle
     * 
     * @param turtle to highlight
     */
    protected TurtleHighlighter (Turtle turtle) {
        myTurtle = turtle;
        updatePosition();

    }

    /**
     * Updates all location variables.
     */
    private void updatePosition () {
        myTopLeft = new Location(myTurtle.getLeft(), myTurtle.getTop());
        myTopRight = new Location(myTurtle.getRight(), myTurtle.getTop());
        myBottomLeft = new Location(myTurtle.getLeft(), myTurtle.getBottom());
        myBottomRight = new Location(myTurtle.getRight(), myTurtle.getBottom());
    }

    @Override
    public void paint (Graphics2D pen) {
        updatePosition();
        pen.setColor(Color.RED);

        // draw top
        pen.drawLine((int) myTopLeft.getX(), (int) myTopLeft.getY(), (int) myTopRight.getX(),
                     (int) myTopRight.getY());
        // draw right
        pen.drawLine((int) myTopRight.getX(), (int) myTopRight.getY(), (int) myBottomRight.getX(),
                     (int) myBottomRight.getY());
        // draw bot
        pen.drawLine((int) myBottomLeft.getX(), (int) myBottomLeft.getY(),
                     (int) myBottomRight.getX(),
                     (int) myBottomRight.getY());
        // draw left
        pen.drawLine((int) myTopLeft.getX(), (int) myTopLeft.getY(), (int) myBottomLeft.getX(),
                     (int) myBottomLeft.getY());

        // the following is for drawing circle highlighter
        // pen.drawOval((int)topLeft.getX() ,(int) topLeft.getY(), (int)myTurtle.getWidth(),
        // (int)myTurtle.getHeight());
    }

}
