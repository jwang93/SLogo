package commands;

import model.Turtle;
import util.Vector;


public class Backward extends AbstractTurtleCommand {
    private int myIncrement;

    public Backward (Turtle turtle, int increment) {
        super(turtle);
        myIncrement = increment;
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        turtle.turn();
        turtle.translate(new Vector(turtle.getHeading(), myIncrement));
        return myIncrement;
    }
    
}
