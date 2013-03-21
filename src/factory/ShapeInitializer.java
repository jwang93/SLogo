package factory;

import java.util.List;
import model.Model;
import commands.*;

public class ShapeInitializer extends AbstractInitializer {

    public ShapeInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Shape(getModel().getTurtle());
    }

}
