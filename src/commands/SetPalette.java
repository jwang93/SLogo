package commands;

import java.util.List;
import model.IModel;


public class SetPalette extends AbstractFourParameterCommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IModel myModel;

    public SetPalette (List<ICommand> parameters, IModel model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        // TODO waiting on View implementation
        return 0;
    }

}
