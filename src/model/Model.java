package model;

import java.awt.Dimension;
import java.io.File;
import java.util.Observer;
import util.DataSource;
import util.Location;
import util.Pixmap;
import commands.ICommand;
import exceptions.FormattingException;
import exceptions.VariableNotFoundException;
import factory.Parser;


public class Model implements IModel {

    private Parser myParser;
    private Turtle myTurtle;
    private Scope myScope;

    public Scope getScope () {
        return myScope;
    }

    public Model (Dimension canvasBounds) {
        myTurtle = new Turtle(calculateCenter(canvasBounds), canvasBounds);
        myScope = new Scope();
        myParser = new Parser(this);
    }

    private Location calculateCenter (Dimension canvasBounds) {
        return new Location((int) canvasBounds.getWidth() / 2, (int) canvasBounds.getHeight() / 2);
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

    @Override
    public void addObserver (Observer observer) {
        myTurtle.addObserver(observer);
    }

}
