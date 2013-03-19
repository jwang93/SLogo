package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the first of our Math commands - the Sum command.
 * Generally, a sum command is easy - SUM 10 10. Simply add the two parameters and return the sum.
 * The tricky case comes with nesting - SUM 10 SUM 10 10. We handle the nesting by calling
 * resolveParameters().
 * 
 * @author Jay Wang
 */
public class Sum extends AbstractDoubleParameterTurtleCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Sum (List<ICommand> parameters) {
        super(parameters, null);
    }

    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () {
        resolveParameters();
        return getFirstParameter() + getSecondParameter();
    }

    @Override
    public String toString () {
        return "sum " + getCommands().get(0) + " " + getCommands().get(1);
    }

}
