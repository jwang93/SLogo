package commands;

import model.workspaces.ITurtle;


public class YCor extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public YCor (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        int position = turtle.getY();
        return position;
    }

    @Override
    public String toString () {
        return "ycor " + getCommands().get(0).toString();
    }

}
