package commands;

import java.util.List;
import util.Location;
import model.Turtle;


public class Towards extends AbstractDoubleParameterTurtleCommand {

    public static final int NUM_ARGS = 2;

    public Towards (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override    
    public int execute () {
        resolveParameters();
        Turtle turtle = getTurtle();
        return (int) turtle.towards(new Location(getFirstParameter(), getSecondParameter()));
    }

    @Override
    public String toString () {
        return "Towards " + getCommands().get(0).toString();
    }


}