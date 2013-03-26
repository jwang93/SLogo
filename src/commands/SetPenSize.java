package commands;

import java.util.List;
import model.Model;
import model.workspaces.ITurtle;


public class SetPenSize extends AbstractSingleParameterCommand implements ICommand {

    /**
     * 
     */
    private Model myModel;
    public static final int NUM_ARGS = 1;

    public SetPenSize (List<ICommand> parameters, Model model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = myModel.getTurtle();
        return turtle.setPenSize(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "setpensize " + getCommands().get(0).toString();
    }

}
