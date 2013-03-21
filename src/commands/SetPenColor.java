package commands;

import java.util.List;
import model.Model;


public class SetPenColor extends AbstractSingleParameterCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Model myModel;
    public static final int NUM_ARGS = 1;

    public SetPenColor (List<ICommand> parameters, Model model) {
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
        return "setpencolor " + getCommands().get(0).toString();
    }

}
