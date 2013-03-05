package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.VariableNotFoundException;
import model.Turtle;

/**
 * Difference Command Implementation - almost identical to that of Sum 
 * @author Jay Wang
 */
public class Difference extends AbstractDoubleParameterCommand {
    public static final int NUM_ARGS = 2;
    List<ICommand> myParameters = new ArrayList<ICommand>();
    
    public Difference (List<ICommand> parameters) {
        super(parameters, null);
    }
    
    @Override
    /**
     * @return the sum of the two parameters
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        return getFirstParameter() - getSecondParameter();
    }
    
    public String toString(){
        return "difference " + getCommands().get(0).toString() + " " + getCommands().get(1).toString(); 
    }
}

