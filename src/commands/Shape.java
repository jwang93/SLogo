package commands;

import model.ITurtle;

public class Shape extends AbstractZeroParameterTurtleCommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Shape (ITurtle turtle) {
        super(turtle);
    }

    public int execute(){
        //TODO waiting for IModel implementation
        return 0;
    }
}
