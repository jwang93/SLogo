package commands;

import model.IModel;


public class Stamp extends AbstractZeroParameterCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IModel myModel;

    public Stamp (IModel model) {
        super();
        myModel = model;

    }

    @Override
    public int execute () {
        // TODO waiting on model implementation
        // What do I return? How about the number of stamps on the board?
        return 0;
    }
}
