package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.PenDown;


public class PenDownInitializer extends AbstractInitializer {

    public PenDownInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(PenDown.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new PenDown(getModel().getTurtle());
    }

}
