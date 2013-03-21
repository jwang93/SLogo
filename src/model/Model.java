package model;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import model.scope.MethodScope;
import model.scope.Scope;
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
    private ITurtle myTurtle;
    private Scope myScope;
    private MethodScope myMethods;
    private int myReturnValue;
    private String myReturnMessage;
    private WorkspaceContainer myWorkspaces;
    private List<Image> myImageList = new ArrayList<Image>();

    /**
     * Instantiates parser, scope, and turtle and passes the canvasBounds.
     * 
     * @param canvasBounds to pass to turtle
     */
    public Model (Dimension canvasBounds) {
        myTurtle = new TurtleContainer(canvasBounds);
        myScope = new Scope();
        myParser = new Parser(this);
        myMethods = new MethodScope();
        myWorkspaces = new WorkspaceContainer(canvasBounds, this);
    }

    /**
     * returns the current turtle
     * 
     * @return turtle to return
     */
    public ITurtle getTurtle () {
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
    
    /**
     * Execution is a two step process. First the parser reads 
     * the String and builds a command tree. The ICommand returned from
     * the parser is the head of the command tree. When <code>execute()</code> 
     * is called the command recursively executes down the tree in 
     * a way that resembles a post-order traversal, although you'd never
     * guess that by looking at the code.  
     */
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
            myReturnMessage = e.getMessage();

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

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileToSave);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
            objectOutputStream.writeObject(myScope); 
            objectOutputStream.writeObject(myMethods); //Currently not working - serializable issues
            objectOutputStream.flush(); 
            objectOutputStream.close(); 
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } 

        System.out.println(fileToSave.getAbsolutePath());
    }

    @Override
    public void loadFunctionsAndVariables (File fileToLoad) {

        try {
            FileInputStream fileInputStream = new FileInputStream(fileToLoad);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
            myScope = (Scope) objectInputStream.readObject();
            myMethods = (MethodScope) objectInputStream.readObject();
            objectInputStream.close(); 
        }
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public DataSource getDataSource () {
        return this;
        //return myWorkspaces.getCurrentWorkspace();
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

    @Override
    public Image getBackgroundImage () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addImage (Image image) {
        myImageList.add(image);        
    }

    @Override
    public void changeToWorkspace (int workspaceNumber) {
        
    }

}
