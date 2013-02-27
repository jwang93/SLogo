package view;

import model.IModel;
import util.Location;


/**
 * View interface, defining methods that the Model needs to interact with the view.
 * 
 * @author David Winegar
 * @author Zhen Gou
 */
public interface IView {

    /**
     * Appends message to command window.
     * @param message message to append to command window
     */
    public void returnMessage (String message);

    /**
     * Clears command window.
     */
    public void clearCommandWindow ();

    /**
     * Updates displayed position to match passed in location.
     * @param location location to display in view
     */
    public void updatePositionLabel (Location location);

    /**
     *  Updates displayed heading to match passed in heading.
     * @param heading heading in degrees to display in view
     */
    public void updateHeadingLabel (int heading);

    /**
     * Sets the model used to communicate with the view.
     * @param model model to use
     */
    public void setModel (IModel model);
}
