package commands;

import model.ITurtle;


public class ClearScreen extends AbstractZeroParameterTurtleCommand implements ICommand {

    /**
     * 
     */
    public static final int NUM_ARGS = 0;

    public ClearScreen (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().clearScreen();
    }

}
