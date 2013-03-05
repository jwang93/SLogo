package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.VariableNotFoundException;

/**
 * Remainder Command Implementation - almost identical to that of Sum 
 * @author Jay Wang
 */
public class Remainder extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();
    
    public Remainder (List<ICommand> parameters) {
        super(parameters);
    }
    
    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        return getFirstParameter() % getSecondParameter();
    }
    

}
