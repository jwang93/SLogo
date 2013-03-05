package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Left;


public class LeftInitializer extends AbstractInitializer {
    public LeftInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Left.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Left(parameters, getModel().getTurtle());
    }

}
