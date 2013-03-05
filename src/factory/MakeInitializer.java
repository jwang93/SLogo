package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Make;

public class MakeInitializer extends AbstractInitializer {

    public MakeInitializer (Model model, Parser parser) {
        super(model, parser);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Make(parameters, getModel().getScope());
    }

}
