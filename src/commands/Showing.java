package commands;

import model.ITurtle;


public class Showing extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public Showing (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        return turtle.isTurtleShowing();
    }

    @Override
    public String toString () {
        return "showing " + getCommands().get(0).toString();
    }

}
