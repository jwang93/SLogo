package commands;

import model.workspaces.ITurtle;


public class ShowTurtle extends AbstractZeroParameterTurtleCommand implements ICommand {
    public static final int NUM_ARGS = 0;

    public ShowTurtle (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().showTurtle();

    }

}
