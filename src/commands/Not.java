package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * Not Command Implementation
 * 
 * @author Jay Wang
 */
public class Not extends AbstractSingleParameterCommand {
    public static final int NUM_ARGS = 1;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Not (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return 1 for param == 0; 0 otherwise
     */
    public int execute () {
        resolveParameters();
        return (getOnlyParameter() == 0) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "not " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
