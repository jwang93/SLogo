package commands;

import java.util.ArrayList;
import java.util.List;


public class Minus extends AbstractSingleParameterCommand {

    public static final int NUM_ARGS = 1;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Minus (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return negative value of parameter
     */
    public int execute () {
        resolveParameters();
        return (-1) * getOnlyParameter();
    }

    @Override
    public String toString () {
        return "quotient " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
