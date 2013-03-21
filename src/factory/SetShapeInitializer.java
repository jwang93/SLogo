package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.SetShape;


public class SetShapeInitializer extends AbstractInitializer {

    public SetShapeInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(SetShape.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetShape(parameters, getModel());
    }

}
