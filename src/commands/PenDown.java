package commands;

import model.ITurtle;


public class PenDown extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public PenDown (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        return turtle.showPen();
    }

    @Override
    public String toString () {
        return "pendown ";
    }

}
