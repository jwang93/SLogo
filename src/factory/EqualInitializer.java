package factory;

import java.util.List;
import model.Model;
import commands.Equal;
import commands.ICommand;


public class EqualInitializer extends AbstractInitializer {

    public EqualInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Equal.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Equal(parameters);
    }

}
