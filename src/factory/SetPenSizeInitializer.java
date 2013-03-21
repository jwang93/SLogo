package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.SetPenSize;

public class SetPenSizeInitializer extends AbstractInitializer {

    public SetPenSizeInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetPenSize.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetPenSize(parameters, getModel());
    }

}
