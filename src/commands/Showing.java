package commands;

import model.Turtle;
import exceptions.VariableNotFoundException;


public class Showing extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public Showing (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () throws VariableNotFoundException {
        Turtle turtle = getTurtle();
        return turtle.isTurtleShowing();
    }

    @Override
    public String toString () {
        return "showing " + getCommands().get(0).toString();
    }

}
