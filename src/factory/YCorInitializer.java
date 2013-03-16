package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.YCor;

public class YCorInitializer extends AbstractInitializer {

    public YCorInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(YCor.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new YCor(getModel().getTurtle());
    }

}
