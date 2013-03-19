package commands;

import java.util.List;
import model.Turtle;


public class Right extends AbstractSingleParameterTurtleCommand {

    public static final int NUM_ARGS = 1;

    public Right (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        Turtle turtle = getTurtle();
        turtle.turn(getOnlyParameter());
        return getOnlyParameter();
    }

    @Override
    public String toString () {
        return "right " + getCommands().get(0).toString();
    }

}
