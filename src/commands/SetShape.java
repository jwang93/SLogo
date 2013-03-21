package commands;

import java.util.List;
import model.Model;


public class SetShape extends AbstractSingleParameterCommand {

    private Model myModel;
    public static final int NUM_ARGS = 1;

    public SetShape (List<ICommand> parameters, Model model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        // TODO how to do this???
        return getOnlyParameter();
    }

    @Override
    public String toString () {
        return "setshape " + getCommands().get(0).toString();
    }

}
