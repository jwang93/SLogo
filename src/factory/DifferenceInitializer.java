package factory;

import java.util.List;
import model.Model;
import commands.Difference;
import commands.ICommand;

public class DifferenceInitializer extends AbstractInitializer {

    public DifferenceInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Difference.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Difference(parameters);
    }
    

}
