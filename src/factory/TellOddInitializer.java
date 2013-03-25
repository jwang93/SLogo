package factory;

import java.util.List;
import commands.ICommand;
import model.Model;

public class TellOddInitializer extends AbstractInitializer {

    public TellOddInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(TellOdd.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new TellOdd(getModel());
    }
    

    

}
