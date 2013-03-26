package commands;

import model.IModel;
import model.Model;
import model.workspaces.ITurtle;


public class Stamp extends AbstractZeroParameterCommand implements ICommand {

    /**
     * 
     */
    private Model myModel;

    public Stamp (Model model) {
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
