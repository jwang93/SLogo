package model;

import java.awt.Dimension;
import java.io.File;
import java.util.Iterator;
import java.util.Observer;
import util.DataSource;
import util.Paintable;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


public class Model implements IModel {

    private Parser myParser;
    private Turtle myTurtle; // TODO instantiate, pass canvasbounds
    private Scope myScope;

    public Scope getScope () {
        return myScope;
    }

    public Model (Dimension canvasBounds) {
        myScope = new Scope();
        myParser = new Parser(this);
    }

    @Override
    public void executeCommand (String command) {

        ICommand executable;
        try {
            executable = myParser.parse(command);
            System.out.println("Return value of command: // " + command + " // = " + executable.execute());
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
    public DataSource getDataSource () {
        return myTurtle;
    }

    public void addObserver (Observer observer) {
        myTurtle.addObserver(observer);
    }

}
