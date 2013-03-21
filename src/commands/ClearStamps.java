package commands;
import model.IModel;
public class ClearStamps extends AbstractZeroParameterCommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IModel myModel;
    public ClearStamps(IModel model){
        myModel = model;
    }
    public int execute(){
        //TODO waiting on View Implementation
        return 0;
    }
}
