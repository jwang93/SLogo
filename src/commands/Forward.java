package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.VariableNotFoundException;
import model.Turtle;


public class Forward extends AbstractSingleParameterTurtleCommand {
    public static final int NUM_ARGS = 1;


    public Forward (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);

    }

    @Override
    /**
     * Resolve the amount to move forward and then 
     * call the turtle's move method to make it go
     * @return the amount of pixels moved
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        Turtle turtle = getTurtle();
        turtle.move(getOnlyParameter());
        return getOnlyParameter();

    }
    public String toString(){
        return "forward " + getCommands().get(0).toString() ;
    }

}
