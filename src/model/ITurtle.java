package model;

import util.Location;


/**
 * This represents the Turtle to the commands. It actually represents a group of turtles in a single
 * workspace and contains methods to handle multiple turtles.
 * 
 * @author David Winegar
 * 
 */
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

    /**
     * Returns the current heading.
     * 
     * @return current heading
     */
    public abstract int getHeading ();

    /**
     * Returns the current X value
     * 
     * @return current X value
     */
    public abstract int getX ();

    /**
     * Returns the current Y value
     * 
     * @return current Y value
     */
    public abstract int getY ();

    /**
     * Sets the background color to the index given.
     * 
     * @param colorIndex index of color
     * @return index
     */
    public abstract int setBackgroundColor (int colorIndex);

    /**
     * Sets the background image to the index given.
     * 
     * @param imageIndex index of image
     * @return index
     */
    public abstract int setBackgroundImage (int imageIndex);

    /**
     * Sets the pen color to the index given.
     * 
     * @param colorIndex index of color
     * @return index
     */
    public abstract int setPenColor (int colorIndex);

    /**
     * Sets the pen size to the number of pixels
     * 
     * @param pixels size
     * @return pixels
     */
    public abstract int setPenSize (int pixels);

    /**
     * Sets the turtle image to the index given.
     * 
     * @param shapeIndex index of image
     * @return index
     */
    public abstract int setShape (int shapeIndex);

    /**
     * Sets the color at colorIndex to the color of the RGB values given
     * 
     * @param colorIndex index of color
     * @param red red value
     * @param green green value
     * @param blue blue value
     * @return index
     */
    public abstract int setPalette (int colorIndex, int red, int green, int blue);

    /**
     * returns index of pen color.
     * 
     * @return index
     */
    public abstract int getPenColor ();

    /**
     * Creates a stamp of all turtles.
     * 
     * @return 0
     */
    public abstract int stamp ();

    /**
     * Clears all stamps
     * 
     * @return 0
     */
    public abstract int clearStamps ();

    /**
     * returns the index of the shape
     * 
     * @return index
     */
    public abstract int getShapeIndex ();

    /**
     * returns the ID of the last active turtle
     * 
     * @return turtleID
     */
    public abstract int getTurtleID ();

    /**
     * Sets all values of turtleIDs to be active, creates them if they do not exist.
     * 
     * @param turtleIds values
     * @return last ID
     */
    public abstract int setActiveTurtles (int ... turtleIds);

    /**
     * Sets all turtles to be active.
     * 
     * @return last ID
     */
    public abstract int setAllTurtlesActive ();

    /**
     * Makes all even valued turtles active
     * 
     * @return last ID
     */
    public abstract int makeEvenTurtlesActive ();

    /**
     * Makes all odd valued turtles active
     * 
     * @return last ID
     */
    public abstract int makeOddTurtlesActive ();

}
