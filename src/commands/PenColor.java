package commands;

import model.ITurtle;


public class PenColor extends AbstractZeroParameterTurtleCommand {

    /**
     * 
     */

    public PenColor (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        // TODO is this implemented yet?
        // return getTurtle().getColor();
        return 0;

    }

}
