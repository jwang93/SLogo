package factory;

import java.util.List;
import model.Model;
import commands.Remainder;
import commands.ICommand;

public class RemainderInitializer extends AbstractInitializer {

    public RemainderInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Remainder.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Remainder(parameters);
    }
    

}
