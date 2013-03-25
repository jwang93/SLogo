package commands;

import model.ITurtle;


public class Shape extends AbstractZeroParameterTurtleCommand {

    /**
     * 
     */

    public Shape (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        ITurtle turtle = getTurtle();
        return turtle.getShapeIndex();
    }
}
