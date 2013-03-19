package commands;

import java.util.List;
import model.Turtle;


public class Left extends AbstractSingleParameterTurtleCommand {

    public static final int NUM_ARGS = 1;

    public Left (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        Turtle turtle = getTurtle();
        turtle.turn((-1) * getOnlyParameter());
        return getOnlyParameter();
    }

    @Override
    public String toString () {
        return "left " + getCommands().get(0).toString() + " ";
    }

}
