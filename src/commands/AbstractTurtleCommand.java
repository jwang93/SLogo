package commands;

import java.util.List;
import model.Turtle;


public abstract class AbstractTurtleCommand extends CommandList implements ICommand {

   
    
    private Turtle myTurtle;

    public AbstractTurtleCommand (List<ICommand> parameters, Turtle turtle) {
        myTurtle = turtle;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }

}
