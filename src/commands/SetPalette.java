package commands;

import java.util.List;
import model.IModel;
import model.ITurtle;


public class SetPalette extends AbstractFourParameterCommand {

    /**
     * 
     */
    private IModel myModel;

    public SetPalette (List<ICommand> parameters, IModel model) {
        super(parameters);
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        ITurtle turtle = myModel.getTurtle();
        return turtle.setPalette(getFirstParameter(), getSecondParameter(), getThirdParameter(), getFourthParameter());
    }

}
