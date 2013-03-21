package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.SetBackground;


public class SetBackgroundInitializer extends AbstractInitializer {

    public SetBackgroundInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetBackground.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetBackground(parameters, getModel());
    }

}
