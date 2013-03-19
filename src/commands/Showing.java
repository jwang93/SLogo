package commands;

import model.Turtle;


public class Showing extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public Showing (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        return turtle.isTurtleShowing();
    }

    @Override
    public String toString () {
        return "showing " + getCommands().get(0).toString();
    }

}
