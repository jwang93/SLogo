package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.VariableNotFoundException;


/**
 * Product Command Implementation - almost identical to that of Sum
 * 
 * @author Jay Wang
 */
public class Product extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();

    public Product (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        return getFirstParameter() * getSecondParameter();
    }

    @Override
    public String toString () {
        return "product " + getCommands().get(0) + " " + getCommands().get(1);
    }
}
