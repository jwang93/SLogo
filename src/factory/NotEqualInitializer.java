package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.NotEqual;


public class NotEqualInitializer extends AbstractInitializer {

    public NotEqualInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(NotEqual.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new NotEqual(parameters);
    }

}
