package model;

import java.awt.Dimension;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import util.DataSource;
import util.Location;
import util.Paintable;
import util.Pixmap;
import commands.ICommand;
import exceptions.FormattingException;
import exceptions.VariableNotFoundException;
import factory.Parser;


public class Model extends Observable implements IModel, DataSource {

    private Parser myParser;
    private Turtle myTurtle;
    private Scope myScope;

    public Scope getScope () {
        return myScope;
    }

    public Model (Dimension canvasBounds) {
        myTurtle = new Turtle(canvasBounds);
        myScope = new Scope();
        myParser = new Parser(this);
    }

    @Override
    public void executeCommand (String command) {

        ICommand executable;
        try {
            executable = myParser.parse(command);
            //executable.execute();
            System.out.println("Command return value: " + executable.execute());
        }
        catch (FormattingException e) {
            // TODO Make Duvall Happy
            // TODO change return message in datasource, notify, then change back to nothing
        }
        catch (VariableNotFoundException e) {
            // TODO do roughly the same thing here
        }
        finally {
            // TODO anything else that should be done in both cases
            notifyView();
        }

    }
    
    private void notifyView () {
        setChanged();
        notifyObservers();
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
        return this;
    }
    
    public void initializeObserver (Observer observer) {
        addObserver(observer);
    }

    @Override
    public Iterator<Paintable> getPaintableIterator () {
        return myTurtle.getPaintableIterator();
    }

    @Override
    public int getReturnValue () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Location getTurtlePosition () {
        return myTurtle.getTurtlePosition();
    }

    @Override
    public int getTurtleHeading () {
        return myTurtle.getTurtleHeading();
    }

    @Override
    public String showMessage () {
        // TODO Auto-generated method stub
        return null;
    }
}
