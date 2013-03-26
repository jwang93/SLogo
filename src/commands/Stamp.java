package commands;

import model.IModel;
import model.ITurtle;


public class Stamp extends AbstractZeroParameterCommand implements ICommand {

    /**
     * 
     */
    private IModel myModel;

    public Stamp (IModel model) {
        super();
        myModel = model;

    }

    @Override
    public int execute () {
        ITurtle turtle = myModel.getTurtle();
        turtle.stamp();
        return 0;
    }
}
