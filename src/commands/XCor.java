package commands;

import model.Turtle;
import exceptions.VariableNotFoundException;


public class XCor extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public XCor (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () throws VariableNotFoundException {
        Turtle turtle = getTurtle();
        int position = (int) turtle.getTurtlePosition().x;
        return position;
    }

    @Override
    public String toString () {
        return "xcor " + getCommands().get(0).toString();
    }

}
