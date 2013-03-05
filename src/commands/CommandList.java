package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * We basically treat all commands as a list of sub commands to run. the only exceptions
 * are constants and variables (both of which still implement ICommand) and commands
 * that take no parameters such as PENUP, as these represent the bottom of a command 
 * tree (i.e. they have no parameters to evaluate)
 * Most commands will extend this class, and will contain their parameters 
 * in the collection.
 * 
 * CommandList Represents a collection of commands to be executed. This is the base class 
 * for anything that involves parameters, This can also be used to make the custom 
 * commands that the user enters. In addition this functions as a root or main command 
 * from which a program is executed. This returns 0 if there are no commands to execute
 */
public class CommandList implements ICommand {

    private static final int DEFAULT_RETURN = 0;

    private List<ICommand> myCommands = new ArrayList<ICommand>();
    protected List<ICommand> getCommands () {
        return myCommands;
    }

    protected void setCommands (List<ICommand> Commands) {
        this.myCommands =Commands;
    }

    private int myReturn = DEFAULT_RETURN;

    public CommandList () {
        // TODO Auto-generated constructor stub
    }

    public CommandList (List<ICommand> parameters) {
        myCommands = parameters;
    }

    @Override
    public int execute () {
        for (ICommand command : myCommands) {
            myReturn = command.execute();
        }
        return myReturn;
    }

    public void add (ICommand command) {
        myCommands.add(command);
    }

}
