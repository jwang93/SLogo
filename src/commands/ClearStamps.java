package commands;

import model.IModel;
import model.ITurtle;


public class ClearStamps extends AbstractZeroParameterCommand {

    /**
     * 
     */
    private IModel myModel;

    public ClearStamps (IModel model) {
        myModel = model;
    }

    @Override
    public int execute () {
        ITurtle turtle = myModel.getTurtle();
        turtle.clearStamps();
        return 0; 
    }
}
