package commands;

import model.Turtle;


public class PenDown extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public PenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        return turtle.showPen();
    }

    @Override
    public String toString () {
        return "pendown ";
    }

}
