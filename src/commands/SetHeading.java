package commands;

import java.util.List;
import model.ITurtle;


public class SetHeading extends AbstractSingleParameterTurtleCommand {

    public static final int NUM_ARGS = 1;

    public SetHeading (List<ICommand> commands, ITurtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = getTurtle();
        return turtle.setHeading(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "SetHeading " + getCommands().get(0).toString();
    }

}
