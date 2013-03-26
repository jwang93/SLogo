package commands;

import java.util.List;
import model.Model;
import model.workspaces.ITurtle;


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
        ITurtle turtle = myModel.getTurtle();
        return turtle.setShape(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "setshape " + getCommands().get(0).toString();
    }

}
