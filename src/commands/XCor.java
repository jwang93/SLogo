package commands;

import model.workspaces.ITurtle;


public class XCor extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public XCor (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        int position = turtle.getX();
        return position;
    }

    @Override
    public String toString () {
        return "xcor " + getCommands().get(0).toString();
    }

}
