package commands;

import util.Location;
import model.Turtle;

public class ClearScreen extends AbstractZeroParameterTurtleCommand implements ICommand {

    public static final int NUM_ARGS = 0;
    private Turtle myTurtle;
    public ClearScreen (Turtle turtle) {
        super(turtle);
    }
    public int execute(){
        int ret = getTurtle().setLocation(new Location(0,0));
        getTurtle().clearScreen();
        return ret;
    }

}
