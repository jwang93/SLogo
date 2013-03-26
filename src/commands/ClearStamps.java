package commands;

import model.IModel;
import model.ITurtle;
import model.Model;


public class ClearStamps extends AbstractZeroParameterCommand {

    /**
     * 
     */
    private Model myModel;

    public ClearStamps (Model model) {
        myModel = model;
    }

    @Override
    public int execute () {
        ITurtle turtle = myModel.getTurtle();
        turtle.clearStamps();
        return 0; 
    }
}
