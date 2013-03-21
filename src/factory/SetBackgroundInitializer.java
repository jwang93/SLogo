package factory;

import java.util.List;
import commands.*;
import model.Model;
import factory.AbstractInitializer;


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
