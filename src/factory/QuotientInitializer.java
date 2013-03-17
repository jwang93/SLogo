package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Quotient;


public class QuotientInitializer extends AbstractInitializer {

    public QuotientInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Quotient.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Quotient(parameters);
    }

}
