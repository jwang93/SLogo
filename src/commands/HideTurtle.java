package commands;

import model.ITurtle;


public class HideTurtle extends AbstractZeroParameterTurtleCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public HideTurtle (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        getTurtle().hideTurtle();
        return 0;
    }

}
