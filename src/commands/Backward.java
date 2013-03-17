package commands;

import java.util.List;
import model.Turtle;
import util.Vector;


public class Backward extends AbstractSingleParameterTurtleCommand {
    private int myIncrement;

    public Backward (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        // turtle.turn();
        turtle.translate(new Vector(turtle.getHeading(), myIncrement));
        return myIncrement;
    }

    @Override
    public String toString () {
        return "back " + getCommands().get(0).toString() + " ";
    }

}
