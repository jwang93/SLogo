package commands;

import model.ITurtle;


public class Heading extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public Heading (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        int heading = turtle.getHeading();
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
