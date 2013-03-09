package model;

import java.io.File;
import java.util.Observer;
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

    /**
     * Adds View observer of Model. This observer is notified when datasource needs to be queried by
     * View.
     * 
     * @param observer object in the View
     */
    public void initializeObserver (Observer observer);
}
