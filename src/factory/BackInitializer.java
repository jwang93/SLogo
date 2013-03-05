package factory;

import java.util.List;
import model.Model;
import commands.Back;
import commands.ICommand;


public class BackInitializer extends AbstractInitializer {
    public BackInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Back.NUM_ARGS);

    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Back(parameters, getModel().getTurtle());
    }

}
