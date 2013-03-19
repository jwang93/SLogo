package commands;

import model.Turtle;
import commands.AbstractZeroParameterTurtleCommand;
import commands.ICommand;

public class PenUp extends AbstractZeroParameterTurtleCommand implements ICommand {

    public PenUp (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().hidePen();
    }

}
