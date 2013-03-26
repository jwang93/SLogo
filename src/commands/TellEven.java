package commands;

import model.Model;


public class TellEven extends AbstractZeroParameterCommand {

    private Model myModel;

    public TellEven (Model model) {
        myModel = model;
    }

    /**
     * 
     */

    @Override
    public int execute () {
        return myModel.getTurtle().makeEvenTurtlesActive();
    }

}
