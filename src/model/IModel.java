package model;

import java.awt.Image;
import java.io.File;
import util.DataSource;


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
     * Returns the datasource.
     * 
     * @return datasource
     */
    public DataSource getDataSource ();

    public void addImage (Image image);

    public void switchToWorkspace (int workspaceNumber);

}
