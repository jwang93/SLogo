package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Repeat;


public class RepeatInitializer extends AbstractInitializer {

    public RepeatInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Repeat.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Repeat(parameters , getModel().getScope());
    }

}
