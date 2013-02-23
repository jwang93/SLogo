package commands;

import model.Turtle;


public abstract class AbstractTurtleCommand implements ICommand {

    private Turtle myTurtle;

    public AbstractTurtleCommand (Turtle turtle) {
        myTurtle = turtle;
    }

    protected Turtle getTurtle () {
        return myTurtle;
    }

}
