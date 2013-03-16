package commands;

import model.Turtle;


public abstract class AbstractZeroParameterTurtleCommand extends AbstractZeroParameterCommand
        implements ICommand {

    private Turtle myTurtle;

    public AbstractZeroParameterTurtleCommand (Turtle turtle) {
        myTurtle = turtle;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }

}
