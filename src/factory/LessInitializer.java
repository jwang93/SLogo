package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Less;


public class LessInitializer extends AbstractInitializer {

    public LessInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Less.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Less(parameters);
    }

}
