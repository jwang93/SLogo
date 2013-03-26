package model.workspaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Map;
import util.Location;


/**
 * Interface of object that is held in the View and used to give the View information about the
 * model.
 * 
 * @author David Winegar
 * 
 */
public interface DataSource {

    /**
     * Gets the value that the View is supposed to return.
     * 
     * @return current return value
     */
    public int getReturnValue ();

    /**
     * Gets the current turtle position so that the view can display it.
     * 
     * @return current turtle position.
     */
    public Location getTurtlePosition ();

    /**
     * Gets the current turtle heading so that the view can display it.
     * 
     * @return current turtle heading.
     */
    public int getTurtleHeading ();

    /**
     * Gets any additional message for the View to display, usually an error message.
     * 
     * @return message to display
     */

    public Image getBackgroundImage ();

    /**
     * Paints this workspace.
     * 
     * @param pen used for painting
     */
    public void paint (Graphics2D pen);

    /**
     * Returns the color used by the background.
     * 
     * @return background color
     */
    public Color getBackgroundColor ();

    /**
     * Gets the user-created variables in the workspace. Note that this should pass a copy of the
     * variables, and changing this map should not affect the workspace.
     * 
     * @return the user variables, a map of a String to an Integer.
     */
    public Map<String, Integer> getUserVariables ();

    /**
     * Gets the user created functions in the Workspace. Note that this should pass a copy of the
     * functions, and changing this map should not affect the workspace.
     * 
     * @return a map of the function name to the commands that the function does
     */
    public Map<String, String> getUserFunctions ();

    /**
     * Toggles the turtle highlighter.
     */
    public void toggleHighlighter ();
}
