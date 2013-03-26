package commands;

import java.util.List;
import model.workspaces.ITurtle;
import util.Location;


public class Towards extends AbstractDoubleParameterTurtleCommand {

    public static final int NUM_ARGS = 2;

    public Towards (List<ICommand> commands, ITurtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = getTurtle();
        return turtle.towards(new Location(getFirstParameter(), getSecondParameter()));
    }

    @Override
    public String toString () {
        return "Towards " + getCommands().get(0).toString();
    }

}
