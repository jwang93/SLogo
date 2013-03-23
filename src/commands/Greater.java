package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * Greater Command Implementation - almost identical to that of Sum
 * 
 * @author Jay Wang
 */
public class Greater extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Greater (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return 1 for param1 > param2; 0 otherwise
     */
    public int execute () {
        resolveParameters();
        return (getFirstParameter() > getSecondParameter()) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "greater " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
