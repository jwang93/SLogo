package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Greater;


public class GreaterInitializer extends AbstractInitializer {

    public GreaterInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Greater.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Greater(parameters);
    }

}
