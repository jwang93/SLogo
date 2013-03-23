package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Not;


public class NotInitializer extends AbstractInitializer {

    public NotInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Not.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Not(parameters);
    }

}
