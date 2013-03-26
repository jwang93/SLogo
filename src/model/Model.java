package model;

import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import model.scope.MethodScope;
import model.scope.Scope;
import model.workspaces.DataSource;
import model.workspaces.ITurtle;
import model.workspaces.WorkspaceContainer;


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
    private FileWriter myFileWriter;
    private File mySessionFile;
    private Parser myParser;
    private WorkspaceContainer myWorkspaces;
    private FileChannel mySourceChannel;
    private FileChannel myTargetChannel;

    /**
     * Instantiates parser, scope, and turtle and passes the canvasBounds.
     * 
     * @param canvasBounds to pass to turtle
     */
    public Model (Dimension canvasBounds) {

        myWorkspaces = new WorkspaceContainer(canvasBounds);
        // do this second
        myParser = new Parser(this);
        mySourceChannel = null;
        myTargetChannel = null;
        mySessionFile = new File("src/files/session.txt");
        try {
            myFileWriter = new FileWriter(mySessionFile);
        }
        catch (IOException e) {
            // should not happen
            myWorkspaces.getCurrentWorkspace().setReturnValue(ERROR_RETURN_VALUE);
        }
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
     * @return scope of current workspace
     */
    public Scope getScope () {
        return myWorkspaces.getCurrentWorkspace().getScope();
    }

    /**
     * returns the current methodscope
     * 
     * @return methodScipe of current workspace
     */
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
     * 
     * @param command String of command
     */
    @Override
    public void executeCommand (String command) {

        ICommand executable;
        int returnValue = 0;
        try {
            executable = myParser.parse(command);
            returnValue = executable.execute();
        }
        catch (FormattingException e) {
            returnValue = ERROR_RETURN_VALUE;
        }
        finally {
            myWorkspaces.getCurrentWorkspace().setReturnValue(returnValue);
        }
    }

    @Override
    /**
     * 1. Creates the file to be saved and places it into the files package
     * 2. Copies over the contents from session.txt into the new file 
     */
    public void saveFunctionsAndVariables (File file) {

        File fileToSave = new File(file.getAbsolutePath());
        try {
            mySourceChannel = new FileInputStream(mySessionFile).getChannel();
            myTargetChannel = new FileOutputStream(fileToSave).getChannel();
            myTargetChannel.transferFrom(mySourceChannel, 0, mySourceChannel.size());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (mySourceChannel != null) {
                    mySourceChannel.close();
                }
                if (myTargetChannel != null) {
                    myTargetChannel.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    /**
     * 1. Reads the contents of fileToLoad line by line
     * 2. Each line will either be a make or to command
     * 3. Executes each make or to command to "reset" the scope
     */
    public void loadFunctionsAndVariables (File fileToLoad) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileToLoad));
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                executeCommand(line);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Filewriter for the session, used in some parts of the commands
     * 
     * @return FileWriter for session file
     */
    public FileWriter getFileWriter () {
        return myFileWriter;
    }

    /**
     * Sets Filewriter for the session, used in some parts of the commands
     * 
     * @param fileWriter new filewriter
     */
    public void setFileWriter (FileWriter fileWriter) {
        myFileWriter = fileWriter;
    }

    @Override
    public DataSource getDataSource () {
        return myWorkspaces.getCurrentWorkspace();
    }

    @Override
    public void addBackgroundImage (Image image) {
        myWorkspaces.addBackgroundImage(image);
    }

    @Override
    public void addTurtleImage (Image image) {
        myWorkspaces.addTurtleImage(image);
    }

    @Override
    public void switchToWorkspace (int workspaceNumber) {
        myWorkspaces.switchToWorkspace(workspaceNumber);
    }

}
