package commands;

import exceptions.VariableNotFoundException;
import model.Turtle;


public class Heading extends AbstractZeroParameterTurtleCommand {
    
    public static final int NUM_ARGS = 0;

    public Heading (Turtle turtle) {
        super(turtle);
    }

    @Override    
    public int execute () throws VariableNotFoundException {
        Turtle turtle = getTurtle();
        int heading = (int) turtle.getHeading();
        return adjustAngle(heading);
    }
    
    @Override
    public String toString () {
        return "heading " + getCommands().get(0).toString();
    }
    
    private int adjustAngle (int heading) {
        while (heading >= 360) {
            heading -= 360;
        }
        while (heading <= 0) {
            heading += 360;
        }
        return heading;
    }

}