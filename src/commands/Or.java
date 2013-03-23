package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * Or Command Implementation - almost identical to that of And
 * 
 * @author Jay Wang
 */
public class Or extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Or (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return 1 for param1 > 0 && param2 > 0; 0 otherwise
     */
    public int execute () {
        resolveParameters();
        return (getFirstParameter() > 0 || getSecondParameter() > 0) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "or " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
