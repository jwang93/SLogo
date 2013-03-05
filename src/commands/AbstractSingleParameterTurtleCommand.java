package commands;

import java.util.List;
import model.Turtle;

public abstract class AbstractSingleParameterTurtleCommand extends AbstractSingleParameterCommand implements ICommand {

    
    private Turtle myTurtle;
    public AbstractSingleParameterTurtleCommand (List<ICommand> parameters, Turtle turtle) {
        super(parameters);
        myTurtle = turtle;
    }
    protected Turtle getTurtle () {
        return myTurtle;
    }

}
