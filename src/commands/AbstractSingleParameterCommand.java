package commands;

import java.util.List;
import model.Turtle;

/**
 * This class is the base class for commands that take a single Slogo parameter. It may also take 
 * other parameters in Java, but its list of commands should only have a single command
 * in it, usually a constant command. When constructing, this class will ignore all commands in the
 * <code>parameters<code> argument other the first one.
 * @author Will Nance
 *
 */
public abstract class AbstractSingleParameterCommand extends CommandList implements ICommand {
    private static final int PARAMETER_INDEX =1;
    private Turtle myTurtle;
    private int myOnlyParameter;
    private List<ICommand> myChildren;
    
    

    public AbstractSingleParameterCommand (List<ICommand> parameters, Turtle turtle) {
        myTurtle = turtle;
        myChildren=parameters;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }
    /**
     * Called by execute at runtime to recursively execute the function's
     * parameter(s) until it can be resolved to an integer.
     * @param parameters
     */
    protected void resolveParameters(){
        setOnlyParameter(myChildren.get(PARAMETER_INDEX).execute());
    }

    protected List<ICommand> getChildren () {
        return myChildren;
    }
    protected int getOnlyParameter () {
        return myOnlyParameter;
    }

    protected void setOnlyParameter (int myOnlyParameter) {
        this.myOnlyParameter = myOnlyParameter;
    }
    

}