package model;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
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
    public static final String TO_COMMAND = "to";
    public static final String MAKE_COMMAND = "make";



    private FileWriter fileWriter;
    private File sessionFile;
    private Parser myParser;
    private WorkspaceContainer myWorkspaces;
    private FileChannel sourceChannel;
    private FileChannel targetChannel;

    /**
     * Instantiates parser, scope, and turtle and passes the canvasBounds.
     * 
     * @param canvasBounds to pass to turtle
     */
    public Model (Dimension canvasBounds) {
        
        myWorkspaces = new WorkspaceContainer(canvasBounds, this);
        // do this second
        myParser = new Parser(this);
        sourceChannel = null;
        targetChannel = null;
        sessionFile = new File("src/files/session.txt");
        try {
            fileWriter = new FileWriter(sessionFile);
        }
        catch (IOException e) {
            e.printStackTrace();
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
        }
        catch (FormattingException e) {           
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
        
        File fileToSave = new File (file.getAbsolutePath());
        try {
            sourceChannel = new FileInputStream(sessionFile).getChannel();
            targetChannel = new FileOutputStream(fileToSave).getChannel();
            targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());   
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (sourceChannel != null) {
                    sourceChannel.close();
                }
                if (targetChannel != null) {
                    targetChannel.close();
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
    
    public FileWriter getFileWriter () {
        return fileWriter;
    }

    public void setFileWriter (FileWriter fileWriter) {
        this.fileWriter = fileWriter;
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
