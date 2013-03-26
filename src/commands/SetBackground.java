package commands;

import java.util.List;
import model.Model;
import model.workspaces.ITurtle;


public class SetBackground extends AbstractSingleParameterCommand implements ICommand {

    /**
     * 
     */
    public static final int NUM_ARGS = 1;
    private Model myModel;

    public SetBackground (List<ICommand> parameters, Model model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = myModel.getTurtle();
        return turtle.setBackgroundColor(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "setbackground " + getCommands().get(0).toString();
    }
}
