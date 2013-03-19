package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.If;
import commands.IfElse;

public class IfElseInitializer extends AbstractInitializer {

    public IfElseInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(If.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return new IfElse(parameters);
    }

}
