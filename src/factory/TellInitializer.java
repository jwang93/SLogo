package factory;

import java.util.List;
import model.Model;
import commands.Forward;
import commands.ICommand;
import commands.Tell;

public class TellInitializer extends AbstractInitializer {

    public TellInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Tell.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Tell(parameters , getModel());
    }

}
