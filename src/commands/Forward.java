package commands;
import model.Turtle;
import util.Vector;

public class Forward extends AbstractTurtleCommand {
    private int myIncrement; 
    
    public Forward (Turtle turtle, int increment) {
        super(turtle);
        myIncrement =increment;
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        turtle.translate(new Vector(myIncrement, turtle.getHeading()));
        return myIncrement;
    }

}
