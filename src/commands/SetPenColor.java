package commands;

import java.util.List;
import model.ITurtle;
import model.Model;


public class SetPenColor extends AbstractSingleParameterCommand implements ICommand {

    /**
     * 
     */
    private Model myModel;
    public static final int NUM_ARGS = 1;

    public SetPenColor (List<ICommand> parameters, Model model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = myModel.getTurtle();
        return turtle.setPenColor(getOnlyParameter());
    }

    @Override
    public String toString () {
        return "setpencolor " + getCommands().get(0).toString();
    }

}
