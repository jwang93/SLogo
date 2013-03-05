package commands;

import java.util.List;
import exceptions.VariableNotFoundException;
import model.Turtle;

/**
 * This class is the base class for commands that take a single Slogo parameter. It may also take 
 * other parameters in Java, but its list of commands should only have a two commands
 * in it, usually constant commands - though not necessarily. When constructing, this class will ignore all commands in the
 * <code>parameters<code> argument other the first one.
 * @author Will Nance, Jay Wang
 *
 */
public abstract class AbstractDoubleParameterCommand extends CommandList implements ICommand {
    private static final int FIRST_PARAMETER_INDEX = 0;
    private static final int SECOND_PARAMETER_INDEX = 1;

    private Turtle myTurtle;
    private int myFirstParameter; 
    private int mySecondParameter;
    

    public AbstractDoubleParameterCommand (List<ICommand> parameters, Turtle turtle) {
       super(parameters);
        myTurtle = turtle;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }
    /**
     * Called by execute at runtime to recursively execute the function's
     * parameter(s) until it can be resolved to an integer.
     * 
     * CONCERN: I am concerned with how to determine where the first parameter ends and second parameter begins. 
     * @param parameters
     */
    protected void resolveParameters ()throws VariableNotFoundException{
        List<ICommand> myChildren = getCommands();
        setFirstParameter(myChildren.get(FIRST_PARAMETER_INDEX).execute());
        setSecondParameter(myChildren.get(SECOND_PARAMETER_INDEX).execute());
    }

    
    protected int getFirstParameter () {
        return myFirstParameter;
    }
    
    protected int getSecondParameter () {
        return mySecondParameter;
    }

    protected void setFirstParameter (int myFirstParameter) {
        this.myFirstParameter = myFirstParameter;
    }
    
    
    protected void setSecondParameter (int mySecondParameter) {
        this.mySecondParameter = mySecondParameter;
    }

}
