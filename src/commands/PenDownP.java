package commands;

import model.Turtle;


public class PenDownP extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public PenDownP (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        return turtle.isPenDown();
        
    }

    @Override
    public String toString () {
        return "pendown ";
    }

}
