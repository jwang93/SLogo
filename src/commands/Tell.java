package commands;

import java.util.List;
import model.IModel;

public class Tell extends AbstractSingleParameterCommand implements ICommand {
      
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IModel myModel;

    public Tell (List<ICommand> parameters, IModel model) {
        super(parameters);
        myModel = model;
    }
    
    
    public int execute(){
        resolveParameters();
        int turtleIndex = getOnlyParameter();
        myModel.getTurtle().setActiveTurtles(turtleIndex);
        return turtleIndex;
    }
    
    

}
