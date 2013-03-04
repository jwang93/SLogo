package model;

import java.io.File;
import java.util.Iterator;
import util.DataSource;
import util.Paintable;
import commands.ICommand;
import exceptions.FormattingException;
import factory.Parser;


public class Model implements IModel {

    private Parser myParser;
    private Turtle myTurtle; // TODO instantiate

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

}
