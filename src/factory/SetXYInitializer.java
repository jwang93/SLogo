package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.SetXY;


public class SetXYInitializer extends AbstractInitializer {

    public SetXYInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetXY.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetXY(parameters, getModel().getTurtle());
    }

}
