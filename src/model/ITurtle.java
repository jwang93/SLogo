package model;

import java.util.Iterator;
import util.Location;
import util.Paintable;


public interface ITurtle {

    /**
     * Move forward or backward by number of pixels.
     * 
     * @param pixels to move by
     * @return command return value
     */
    public abstract int move (int pixels);

    /**
     * Turns turtle by given degrees.
     * 
     * @param degrees to turn by
     * @return command return value
     */
    public abstract int turn (int degrees);

    /**
     * sets current heading.
     * 
     * @param heading to set
     * @return current heading
     */
    public abstract int setHeading (int heading);

    /**
     * Sets heading to go towards location **AS IN VIEW'S COORDINATES**
     * 
     * @param location location to set heading towards
     * @return distance of turn
     */
    public abstract int towards (Location location);

    /**
     * Moves turtle to location **AS IN VIEW'S COORDINATES**
     * 
     * @param location to move to
     * @return distance of move
     */
    public abstract int setLocation (Location location);

    /**
     * Sets turtle to showing.
     * 
     * @return command value
     */
    public abstract int showTurtle ();

    /**
     * Sets turtle to hiding.
     * 
     * @return command value
     */
    public abstract int hideTurtle ();

    /**
     * Sets lines to show up on new moves.
     * 
     * @return command value
     */
    public abstract int showPen ();

    /**
     * Sets lines to not show up on new moves.
     * 
     * @return command value
     */
    public abstract int hidePen ();

    /**
     * Moves turtle to center and original heading.
     * 
     * @return
     */
    public abstract int home ();

    /**
     * Clears all lines and moves turtle home.
     * 
     * @return
     */
    public abstract int clearScreen ();

    /**
     * Gets if turtle is showing or not.
     * 
     * @return 1 if turtle is showing, 0 if not
     */
    public abstract int isTurtleShowing ();

    /**
     * Gets if pen is down or not.
     * 
     * @return 1 if pen is down, 0 if not
     */
    public abstract int isPenDown ();

    public abstract int getHeading ();

    public abstract int getX ();
    
    public abstract int getY ();
    
    public abstract int setBackgroundColor (int colorIndex);
    
    public abstract int setBackgroundImage (int imageIndex);
    
    public abstract int setPenColor (int colorIndex);
    
    public abstract int setPenSize (int pixels);
    
    public abstract int setShape (int shapeIndex);
    
    public abstract int setPalette (int colorIndex, int red, int green, int blue);
    
    public abstract int getPenColor ();
    
    public abstract int stamp ();
    
    public abstract int clearStamps ();
    
    public abstract int getShapeIndex ();
    
    public abstract int getTurtleID ();
    
    public abstract int setActiveTurtles (int... turtleIds);
    
    public abstract int setAllTurtlesActive ();
    
    public abstract int makeEvenTurtlesActive ();
    
    public abstract int makeOddTurtlesActive ();
    
}