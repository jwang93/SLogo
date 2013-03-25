package commands;

import java.util.List;
import model.ITurtle;
import util.Location;


public class SetXY extends AbstractDoubleParameterTurtleCommand {

    public static final int NUM_ARGS = 2;

    public SetXY (List<ICommand> commands, ITurtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = getTurtle();
        return turtle.setLocation(new Location(getFirstParameter(), getSecondParameter()));
    }

    @Override
    public String toString () {
        return "SetXY " + getCommands().get(0).toString();
    }

}
