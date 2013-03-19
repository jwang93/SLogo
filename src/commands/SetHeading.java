package commands;

import java.util.List;
import model.Turtle;


public class SetHeading extends AbstractSingleParameterTurtleCommand {

    public static final int NUM_ARGS = 1;

    public SetHeading (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override    
    public int execute () {
        resolveParameters();
        Turtle turtle = getTurtle();
        return (int) turtle.setHeading(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "SetHeading " + getCommands().get(0).toString();
    }


}
