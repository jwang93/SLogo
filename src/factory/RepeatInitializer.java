package factory;

import java.util.Iterator;
import java.util.List;
import commands.ICommand;
import commands.Repeat;
import model.Model;

public class RepeatInitializer extends AbstractInitializer {

    public RepeatInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Repeat.NUM_ARGS);
    }

   

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Repeat(parameters);
    }

}
