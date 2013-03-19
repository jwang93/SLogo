package factory;

import java.util.List;
import model.Model;
import commands.Towards;
import commands.ICommand;


public class TowardsInitializer extends AbstractInitializer {

    public TowardsInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Towards.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Towards(parameters, getModel().getTurtle());
    }

}
