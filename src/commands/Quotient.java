package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * Quotient Command Implementation - almost identical to that of Sum
 * 
 * @author Jay Wang
 */
public class Quotient extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Quotient (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () {
        resolveParameters();
        if (getSecondParameter() == 0) {
            System.err.println("ERROR: divide by zero. Aborting.");
            return -1;
        }
        return getFirstParameter() / getSecondParameter();
    }

    @Override
    public String toString () {
        return "quotient " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
