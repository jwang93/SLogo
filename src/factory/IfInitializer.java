package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.If;


public class IfInitializer extends AbstractInitializer {

    public IfInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(If.NUM_ARGS);

    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new If(parameters);
    }

}
