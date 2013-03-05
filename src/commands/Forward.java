package commands;

import java.util.ArrayList;
import java.util.List;
import model.Turtle;


public class Forward extends AbstractSingleParameterCommand {
    public static final int NUM_ARGS = 1;

    List<ICommand> myParameters = new ArrayList<ICommand>();


    public Forward (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);

    }

    @Override
    /**
     * Resolve the amount to move forward and then 
     * call the turtle's move method to make it go
     * @return the amount of pixels moved
     */
    public int execute () {
        resolveParameters();
        Turtle turtle = getTurtle();
        turtle.move(getOnlyParameter());
        return getOnlyParameter();

    }
    
}
