package commands;

import java.util.ArrayList;
import java.util.List;


/**
 * Product Command Implementation - almost identical to that of Sum
 * 
 * @author Jay Wang
 */
public class Less extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Less (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () {
        resolveParameters();
        System.out.println("Getting read");
        return (getFirstParameter() < getSecondParameter()) ? 1 : 0;
    }

    @Override
    public String toString () {
        return "less " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
