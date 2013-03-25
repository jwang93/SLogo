package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;
import java.util.Map;


/**
 * Interface of object that is held in the View and used to give the View information about the
 * model.
 * 
 * @author David Winegar
 * 
 */
public interface DataSource {
    /**
     * Gets the paintable objects in the Model.
     * 
     * @return iterator of objects in the Model
     */
    public Iterator<Paintable> getPaintableIterator ();

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

    public void paint (Graphics2D pen);

    public Color getBackgroundColor ();

    public Map<String, Integer> getUserVariables ();

    public Map<String, String> getUserFunctions ();

    public void toggleHighlighter ();
}
