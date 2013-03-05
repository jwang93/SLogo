package commands;

import java.util.List;
import model.Turtle;


public abstract class AbstractDoubleParameterTurtleCommand extends AbstractDoubleParameterCommand
        implements ICommand {
    private Turtle myTurtle;

    public AbstractDoubleParameterTurtleCommand (List<ICommand> parameters, Turtle turtle) {
        super(parameters);
        myTurtle = turtle;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }
}
