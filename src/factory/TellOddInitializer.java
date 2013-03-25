package factory;

import java.util.List;
import model.Model;
import commands.AbstractZeroParameterCommand;
import commands.ICommand;


public class TellOddInitializer extends AbstractInitializer {

    public TellOddInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(AbstractZeroParameterCommand.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new TellOdd(getModel());
    }

}
