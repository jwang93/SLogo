package commands;

import java.util.List;
import model.ITurtle;


public abstract class AbstractDoubleParameterTurtleCommand extends AbstractDoubleParameterCommand
        implements ICommand {
    private ITurtle myTurtle;

    public AbstractDoubleParameterTurtleCommand (List<ICommand> parameters, ITurtle turtle) {
        super(parameters);
        myTurtle = turtle;
    }

    protected ITurtle getTurtle () {
        return myTurtle;
    }
}
