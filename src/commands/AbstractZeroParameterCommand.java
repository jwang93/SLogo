package commands;

import java.util.List;


/**
 * This class is the base class for commands that take no Slogo parameter - commands such
 * as Turtle queries.
 * 
 * @author Jay Wang
 * 
 */
public abstract class AbstractZeroParameterCommand extends CommandList implements ICommand {
    private static final int NUM_ARGS = 0;

    public AbstractZeroParameterCommand () {
        super();
    }

    public AbstractZeroParameterCommand (List<ICommand> parameters) {
        super(parameters);
    }
}
