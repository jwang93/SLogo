package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Or;


public class OrInitializer extends AbstractInitializer {

    public OrInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Or.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Or(parameters);
    }

}
