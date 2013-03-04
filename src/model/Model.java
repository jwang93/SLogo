package model;

import java.io.File;
import java.util.Iterator;
import util.DataSource;
import util.Paintable;
import view.IView;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


public class Model implements IModel, DataSource {
    private static final int ERROR_RETURN_VALUE = -1;

    private Parser myParser;
    private Turtle myTurtle; // TODO instantiate

    public Model (IView view) {
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

    public Turtle getTurtle () {
        return myTurtle;
    }

}
