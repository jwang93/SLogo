package commands;

import model.Turtle;


public class YCor extends AbstractZeroParameterTurtleCommand {

    public static final int NUM_ARGS = 0;

    public YCor (Turtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
        int position = (int) turtle.getTurtlePosition().y;
        return position;
    }

    @Override
    public String toString () {
        return "ycor " + getCommands().get(0).toString();
    }

}
