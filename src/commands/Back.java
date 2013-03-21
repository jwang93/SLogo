package commands;

import java.util.List;
import model.ITurtle;


public class Back extends AbstractSingleParameterTurtleCommand {

    public static final int NUM_ARGS = 1;

    public Back (List<ICommand> commands, ITurtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = getTurtle();
        turtle.move((-1) * getOnlyParameter());
        return getOnlyParameter();
    }

    @Override
    public String toString () {
        return "back " + getCommands().get(0).toString() + " ";
    }

}
