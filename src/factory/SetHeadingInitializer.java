package factory;

import java.util.List;
import model.Model;
import commands.SetHeading;
import commands.ICommand;


public class SetHeadingInitializer extends AbstractInitializer {
    public SetHeadingInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetHeading.NUM_ARGS);

    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        System.out.println("Info: " + parameters.get(0).toString());
        return new SetHeading(parameters, getModel().getTurtle());
    }

}
