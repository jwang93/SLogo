package factory;

import model.Model;
import commands.AbstractZeroParameterCommand;
import commands.ICommand;


public class TellOdd extends AbstractZeroParameterCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Model myModel;

    public TellOdd (Model model) {
        myModel = model;
    }

    @Override
    public int execute () {
        return myModel.getTurtle().makeOddTurtlesActive();
    }

}
