package commands;

import java.util.List;
import util.Location;
import model.ITurtle;


public class Towards extends AbstractDoubleParameterTurtleCommand {

    public static final int NUM_ARGS = 2;

    public Towards (List<ICommand> commands, ITurtle turtle) {
        super(commands, turtle);
    }

    @Override    
    public int execute () {
        resolveParameters();
        ITurtle turtle = getTurtle();
        return (int) turtle.towards(new Location(getFirstParameter(), getSecondParameter()));
    }

    @Override
    public String toString () {
        return "Towards " + getCommands().get(0).toString();
    }


}