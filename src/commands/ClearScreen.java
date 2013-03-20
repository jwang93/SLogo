package commands;

import util.Location;
import model.Turtle;

public class ClearScreen extends AbstractZeroParameterTurtleCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int NUM_ARGS = 0;
    private Turtle myTurtle;
    public ClearScreen (Turtle turtle) {
        super(turtle);
    }
    public int execute(){
        return getTurtle().clearScreen();
    }

}
