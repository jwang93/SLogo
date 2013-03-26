package model;

import java.awt.Image;
import java.io.File;


/**
 * Represents the Model to the View.
 * 
 * @author David Winegar
 * 
 */
public interface IModel {
    /**
     * Executes the user-inputted command.
     * 
     * @param command entered text to execute
     */
    public void executeCommand (String command);

    /**
     * Saves all current functions and variables to file.
     * 
     * @param fileToSave file to save to
     */
    public void saveFunctionsAndVariables (File fileToSave);

    /**
     * Loads all current functions and variables from file.
     * 
     * @param fileToLoad file to load from
     */
    public void loadFunctionsAndVariables (File fileToLoad);

    /**
     * Returns the current datasource referring to the current workspace.
     * 
     * @return datasource
     */
    public DataSource getDataSource ();

    /**
     * Adds the background image to the list in model.
     * 
     * @param image to add
     */
    public void addBackgroundImage (Image image);

    /**
     * Adds the turtle image to the list in model.
     * 
     * @param image to add
     */
    public void addTurtleImage (Image image);

    /**
     * switches to workspace number passed in
     * 
     * @param workspaceNumber ID of the workspace
     */
    public void switchToWorkspace (int workspaceNumber);

}
