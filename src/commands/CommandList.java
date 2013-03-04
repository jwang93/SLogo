package commands;

import java.util.ArrayList;
import java.util.List;


public class CommandList implements ICommand {

    private static final int DEFAULT_RETURN = 0;
    /**
     * represents a collection of commands to be executed. This is the base class for
     * anything that involves multiple commands, including if statements and
     * repeat commands, which can have a block of commands to be executed.
     * This can also be used to make the custom commands that the user enters
     */

    private List<ICommand> myCommands = new ArrayList<ICommand>();
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
