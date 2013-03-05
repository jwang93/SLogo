package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import exceptions.VariableNotFoundException;

/**
 * This command - Random - goes against the general class naming conventions being called Random. 
 * This is because if it was called Random, I won't be able to import java.util.Random 
 * @author Jay Wang
 */
public class RandomCommand extends AbstractSingleParameterCommand {
    
    public static final int NUM_ARGS = 1;
    List<ICommand> myParameters = new ArrayList<ICommand>();
    
    public RandomCommand (List<ICommand> parameters) {
        super(parameters);
    }
    
    @Override
    /**
     * @return random value up to parameter
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        return new Random().nextInt(getOnlyParameter());
    }
    
}
