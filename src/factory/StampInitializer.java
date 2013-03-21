package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Stamp;


public class StampInitializer extends AbstractInitializer {

    public StampInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Stamp(getModel());
    }

}
