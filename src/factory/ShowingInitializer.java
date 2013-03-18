package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Showing;


public class ShowingInitializer extends AbstractInitializer {

    public ShowingInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Showing.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Showing(getModel().getTurtle());
    }

}
