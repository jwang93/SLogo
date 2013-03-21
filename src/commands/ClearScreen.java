package commands;

import model.ITurtle;


public class ClearScreen extends AbstractZeroParameterTurtleCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int NUM_ARGS = 0;
    private ITurtle myTurtle;

    public ClearScreen (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().clearScreen();
    }

}
