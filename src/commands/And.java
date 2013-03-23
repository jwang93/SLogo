package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * And Command Implementation - almost identical to that of Sum
 * 
 * @author Jay Wang
 */
public class And extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public And (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return 1 for param1 > 0 && param2 > 0; 0 otherwise
     */
    public int execute () {
        resolveParameters();
        return (getFirstParameter() > 0 && getSecondParameter() > 0) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "and " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
