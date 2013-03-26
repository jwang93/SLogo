package commands;

import model.workspaces.ITurtle;


public abstract class AbstractZeroParameterTurtleCommand extends AbstractZeroParameterCommand
        implements ICommand {
    public static final int NUM_ARGS = 0;
    private ITurtle myTurtle;

    public AbstractZeroParameterTurtleCommand (ITurtle turtle) {
        myTurtle = turtle;
    }

    protected ITurtle getTurtle () {
        return myTurtle;
    }

}
