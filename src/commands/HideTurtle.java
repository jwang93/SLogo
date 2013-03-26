package commands;

import model.workspaces.ITurtle;


public class HideTurtle extends AbstractZeroParameterTurtleCommand implements ICommand {

    /**
     * 
     */

    public HideTurtle (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        getTurtle().hideTurtle();
        return 0;
    }

}
