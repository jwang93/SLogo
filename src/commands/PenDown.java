package commands;

import model.Turtle;
import exceptions.VariableNotFoundException;


public class PenDown extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public PenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () throws VariableNotFoundException {
        Turtle turtle = getTurtle();
        return turtle.isPenDown();
    }

    @Override
    public String toString () {
        return "pendown " + getCommands().get(0).toString();
    }

}
