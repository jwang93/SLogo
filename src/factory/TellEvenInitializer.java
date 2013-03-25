package factory;

import java.util.List;
import model.Model;
import commands.AbstractZeroParameterCommand;
import commands.ICommand;
import commands.TellEven;


public class TellEvenInitializer extends AbstractInitializer {

    public TellEvenInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(AbstractZeroParameterCommand.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new TellEven(getModel());
    }

}
