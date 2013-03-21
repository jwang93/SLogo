package commands;

import model.ITurtle;
import commands.AbstractZeroParameterTurtleCommand;
import commands.ICommand;

public class PenUp extends AbstractZeroParameterTurtleCommand implements ICommand {

    public PenUp (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().hidePen();
    }

}
