package commands;
import model.Model;
import java.util.List;

public class SetBackground extends AbstractSingleParameterCommand implements ICommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int NUM_ARGS = 1;
    private Model myModel;

    public SetBackground (List<ICommand> parameters , Model model) {
        super(parameters);
        myModel  = model;
    }
    @Override
    public int execute(){
        resolveParameters();
        //TODO how to do this???
        return getOnlyParameter();
    }

    
    public String toString(){
        return "setbackground " + getCommands().get(0).toString();
    }
}
