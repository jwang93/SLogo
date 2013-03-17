package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.RandomCommand;


public class RandomInitializer extends AbstractInitializer {

    public RandomInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(RandomCommand.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new RandomCommand(parameters);
    }

}
