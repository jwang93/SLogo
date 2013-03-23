package commands;

import java.util.List;
import model.ITurtle;


public abstract class AbstractSingleParameterTurtleCommand extends AbstractSingleParameterCommand
        implements ICommand {

    private ITurtle myTurtle;

    public AbstractSingleParameterTurtleCommand (List<ICommand> parameters, ITurtle turtle) {
        super(parameters);
        myTurtle = turtle;
    }

    protected ITurtle getTurtle () {
        return myTurtle;
    }
    
    

}
