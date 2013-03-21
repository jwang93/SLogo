package commands;

import model.ITurtle;
import model.Turtle;


public class PenDownP extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public PenDownP (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        return turtle.isPenDown();
        
    }

    @Override
    public String toString () {
        return "pendown ";
    }

}
