package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.SetPenColor;


public class SetPenColorInitializer extends AbstractInitializer {

    public SetPenColorInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetPenColor.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetPenColor(parameters, getModel());
    }

}
