package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * NotEqual Command Implementation - almost identical to that of Equal
 * 
 * @author Jay Wang
 */
public class NotEqual extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public NotEqual (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return 1 for param1 != param2; 0 otherwise
     */
    public int execute () {
        resolveParameters();
        return (getFirstParameter() != getSecondParameter()) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "notequal " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
