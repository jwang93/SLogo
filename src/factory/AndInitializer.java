package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.And;


public class AndInitializer extends AbstractInitializer {

    public AndInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(And.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new And(parameters);
    }

}
