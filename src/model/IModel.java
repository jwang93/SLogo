package model;

import java.io.File;
import java.util.Observer;
import util.DataSource;


public interface IModel {
    public void executeCommand (String command);

    public void saveFunctionsAndVariables (File fileToSave);

    public void loadFunctionsAndVariables (File fileToLoad);
    
    public DataSource getDataSource();

    public void initializeObserver(Observer observer);
}
