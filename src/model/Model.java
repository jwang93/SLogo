package model;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import util.DataSource;
import util.Location;
import util.Paintable;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


/**
 * The main Model class.
 * 
 * @author Zhen Gou
 * @author David Winegar
 * @author Will Nance
 * @author Jay Wang
 * 
 */
public class Model extends Observable implements IModel, DataSource {

    /**
     * return value in the event of an error.
     */
    public static final int ERROR_RETURN_VALUE = -1;

    private Parser myParser;
    private Turtle myTurtle;
    private Scope myScope;
    private MethodScope myMethods;
    private int myReturnValue;
    private String myReturnMessage;

    /**
     * Instantiates parser, scope, and turtle and passes the canvasBounds.
     * 
     * @param canvasBounds to pass to turtle
     */
    public Model (Dimension canvasBounds) {
        myTurtle = new Turtle(canvasBounds);
        myScope = new Scope();
        myParser = new Parser(this);
        myMethods = new MethodScope();
    }

    /**
     * returns the current turtle
     * 
     * @return turtle to return
     */
    public Turtle getTurtle () {
        return myTurtle;

    }

    /**
     * returns the current scope
     * 
     * @return myScope
     */
    public Scope getScope () {
        return myScope;
    }

    @Override
    public void executeCommand (String command) {

        ICommand executable;
        int returnValue = ERROR_RETURN_VALUE;
        try {
            executable = myParser.parse(command);
            returnValue = executable.execute();
            myReturnMessage = "";
        }
        catch (FormattingException e) {
            myReturnMessage = "Formatting error";

        }

        finally {
            myReturnValue = returnValue;
            notifyView();
        }

    }

    /**
     * sets observable as changed and notifies observers.
     */
    private void notifyView () {
        setChanged();
        notifyObservers();
    }

    @Override
    public void saveFunctionsAndVariables (File fileToSave) {

        Scope scope1 = myScope;
        MethodScope scope2 = myMethods;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileToSave);
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            oos.writeObject(scope1); 
            oos.writeObject(scope2);
            oos.flush(); 
            oos.close(); 
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        System.out.println(fileToSave.getAbsolutePath());
    }

    @Override
    public void loadFunctionsAndVariables (File fileToLoad) {
        // not implemented :(
        
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileToLoad);
            ois = new ObjectInputStream(fis); 
            myScope = (Scope)ois.readObject();
            myMethods = (MethodScope)ois.readObject();
            ois.close(); 
        }
        
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        

    }

    @Override
    public DataSource getDataSource () {
        return this;
    }

    @Override
    public void initializeObserver (Observer observer) {
        addObserver(observer);
    }

    @Override
    public Iterator<Paintable> getPaintableIterator () {
        return myTurtle.getPaintableIterator();
    }

    @Override
    public int getReturnValue () {
        return myReturnValue;
    }

    @Override
    public Location getTurtlePosition () {
        return myTurtle.getTurtlePosition();
    }

    @Override
    public int getTurtleHeading () {
        return (int) myTurtle.getHeading();
    }

    @Override
    public String showMessage () {
        return myReturnMessage;
    }

    /**
     * Sets current return value
     * 
     * @param value to set
     */
    public void setReturnValue (int value) {
        myReturnValue = value;
    }

    /**
     * Sets the return message
     * 
     * @param message to set
     */
    public void setReturnMessage (String message) {
        myReturnMessage = message;
    }

    public MethodScope getMethods () {
        return myMethods;
    }
}
