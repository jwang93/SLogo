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
import java.util.List;
import model.scope.MethodScope;
import model.scope.Scope;
import util.DataSource;
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
public class Model implements IModel {

    /**
     * return value in the event of an error.
     */
    public static final int ERROR_RETURN_VALUE = -1;

    private Parser myParser;
    private WorkspaceContainer myWorkspaces;

    /**
     * Instantiates parser, scope, and turtle and passes the canvasBounds.
     * 
     * @param canvasBounds to pass to turtle
     */
    public Model (Dimension canvasBounds) {
        
        myWorkspaces = new WorkspaceContainer(canvasBounds, this);
        // do this second
        myParser = new Parser(this);
    }

    /**
     * returns the current turtle
     * 
     * @return turtle to return
     */
    public ITurtle getTurtle () {
        return myWorkspaces.getCurrentWorkspace();
    }

    /**
     * returns the current scope
     * 
     * @return myScope
     */
    public Scope getScope () {
        return myWorkspaces.getCurrentWorkspace().getScope();
    }
    
    public MethodScope getMethodScope () {
        return myWorkspaces.getCurrentWorkspace().getMethodScope();
    }

    /**
     * Execution is a two step process. First the parser reads
     * the String and builds a command tree. The ICommand returned from
     * the parser is the head of the command tree. When <code>execute()</code> is called the command
     * recursively executes down the tree in
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
            System.out.println(returnValue);
        }
        catch (FormattingException e) {
            
        }

        finally {
            myWorkspaces.getCurrentWorkspace().setReturnValue(returnValue);
        }

    }

    @Override
    public void saveFunctionsAndVariables (File fileToSave) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileToSave);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(getScope());
            objectOutputStream.writeObject(getMethodScope()); // Currently not working - serializable
                                                       // issues
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
            // scope now in myWorkspaces.currentWorkspace(), need to combine this with that
            // = (Scope) objectInputStream.readObject();
            // = (MethodScope) objectInputStream.readObject();
            objectInputStream.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //catch (ClassNotFoundException e) {
        //    e.printStackTrace();
       // }
    }

    @Override
    public DataSource getDataSource () {
        return myWorkspaces.getCurrentWorkspace();
    }

    @Override
    public void switchToWorkspace (int workspaceNumber) {
        myWorkspaces.switchToWorkspace(workspaceNumber);
    }

    @Override
    public void addBackgroundImage (Image image) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addTurtleImage (Image image) {
        // TODO Auto-generated method stub
        
    }

    public MethodScope getMethods(){ return myWorkspaces.getMethods();}
}
