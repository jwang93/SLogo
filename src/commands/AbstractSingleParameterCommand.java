package commands;

import java.util.List;


/**
 * This class is the base class for commands that take a single Slogo parameter. It may also take
 * other parameters in Java, but its list of commands should only have a single command
 * in it, usually a constant command. When constructing, this class will ignore all commands in the
 * <code>parameters<code> argument other the first one.
 * 
 * @author Will Nance
 * 
 */
public abstract class AbstractSingleParameterCommand extends CommandList implements ICommand {
    private static final int PARAMETER_INDEX = 0;
    private int myOnlyParameter;

    public AbstractSingleParameterCommand (List<ICommand> parameters) {
        super(parameters);
    }

    /**
     * Called by execute at runtime to recursively execute the function's
     * parameter(s) until it can be resolved to an integer.
     * 
     * @param parameters
     */
    protected void resolveParameters () {
        List<ICommand> myChildren = getCommands();
        setOnlyParameter(myChildren.get(PARAMETER_INDEX).execute());
    }

    protected int getOnlyParameter () {
        return myOnlyParameter;
    }

    protected void setOnlyParameter (int myOnlyParameter) {
        this.myOnlyParameter = myOnlyParameter;
    }

}
