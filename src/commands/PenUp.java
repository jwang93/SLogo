package commands;

import model.workspaces.ITurtle;


public class PenUp extends AbstractZeroParameterTurtleCommand implements ICommand {

    public PenUp (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().hidePen();
    }

}
