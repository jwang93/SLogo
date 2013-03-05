package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Sum;

public class SumInitializer extends AbstractInitializer {

    public SumInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Sum.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Sum(parameters);
    }
    

}
