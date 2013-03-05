package commands;

import java.util.List;
import exceptions.VariableNotFoundException;
import model.Turtle;


public class Right extends AbstractSingleParameterTurtleCommand {
    
    public static final int NUM_ARGS = 1;

    public Right (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override    
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        Turtle turtle = getTurtle();
        turtle.turn((double) getOnlyParameter());
        return getOnlyParameter();
    }
    
    @Override
    public String toString () {
        return "right " + getCommands().get(0).toString();
    }

}
