package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Minus;


public class MinusInitializer extends AbstractInitializer {

    public MinusInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Minus.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Minus(parameters);
    }

}
