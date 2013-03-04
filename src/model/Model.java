package model;

import java.io.File;
import java.util.Iterator;
import util.DataSource;
import util.Location;
import util.Paintable;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


public class Model implements IModel, DataSource {
    private static final int ERROR_RETURN_VALUE = -1;

    private Parser myParser;
    private Turtle myTurtle; //TODO instantiate

    public Model () {
        // TODO make parser
    }

    @Override
    public void executeCommand (String command) {

        ICommand executable;
        try {
            executable = myParser.parse(command);
        }
        catch (FormattingException e) {
            // TODO Make Duvall Happy
            // TODO change return message in datasource, notify, then change back to nothing
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
    
    @Override
    public Iterator<Paintable> getPaintableIterator () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getReturnValue () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Location getTurtlePosition () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getTurtleHeading () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String showMessage () {
        // TODO Auto-generated method stub
        return null;

    }

}