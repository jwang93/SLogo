package commands;

import java.util.List;
import model.Model;

public class TellEven extends AbstractZeroParameterCommand {

    private Model myModel;

    public TellEven ( Model model) {
        myModel = model;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public int execute(){
        return myModel.getTurtle().makeEvenTurtlesActive();
    }

}
