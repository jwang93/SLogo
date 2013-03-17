package commands;

/**
 * This class is the base class for commands that take no Slogo parameter - commands such
 * as Turtle queries.
 * 
 * @author Jay Wang
 * 
 */
public abstract class AbstractZeroParameterCommand extends CommandList implements ICommand {

    public AbstractZeroParameterCommand () {
        super();
    }
}
