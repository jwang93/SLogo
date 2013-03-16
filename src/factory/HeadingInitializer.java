package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Heading;

public class HeadingInitializer extends AbstractInitializer {

    public HeadingInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Heading.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Heading(getModel().getTurtle());
    }

}
