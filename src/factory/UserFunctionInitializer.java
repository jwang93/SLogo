package factory;

import java.util.List;
import model.Model;
import commands.ICommand;

public class UserFunctionInitializer extends AbstractInitializer {

    public UserFunctionInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return null;
    }

}
