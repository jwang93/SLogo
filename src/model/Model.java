package model;

import java.io.File;
import java.util.Iterator;
import util.Datasource;
import util.Paintable;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


public class Model implements IModel, Datasource {
    private static final int ERROR_RETURN_VALUE = -1;

    private Parser myParser;

    public Model () {
        // TODO make parser
    }

    @Override
    public Iterator<Paintable> getPaintableIterator () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeCommand (String command) {

        ICommand executable;
        try {
            executable = myParser.parse(command);
            return executable.execute();
        }
        catch (FormattingException e) {
            // TODO Make Duvall Happy
            return ERROR_RETURN_VALUE;
        }

    }

    @Override
    public void saveFunctionsAndVariables (File fileToSave) {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadFunctionsAndVariables (File fileToLoad) {
        // TODO Auto-generated method stub

    }

}
