package model;

import java.io.File;


public interface IModel {
    public void executeCommand (String command);

    public void saveFunctionsAndVariables (File fileToSave);

    public void loadFunctionsAndVariables (File fileToLoad);

}
