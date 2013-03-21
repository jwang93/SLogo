package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.PenColor;


public class PenColorInitializer extends AbstractInitializer {

    public PenColorInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new PenColor(getModel().getTurtle());
    }

}
