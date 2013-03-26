package commands;

import java.util.List;
import model.IModel;
import model.ITurtle;
import model.Model;


public class SetPalette extends AbstractFourParameterCommand {

    /**
     * 
     */
    private Model myModel;

    public SetPalette (List<ICommand> parameters, Model model) {
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
