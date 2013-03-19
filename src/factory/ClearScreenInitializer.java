package factory;

import java.util.List;
import model.Model;
import commands.ClearScreen;
import commands.ICommand;
import exceptions.FormattingException;

public class ClearScreenInitializer extends AbstractInitializer {

    public ClearScreenInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(ClearScreen.NUM_ARGS);
        // TODO Auto-generated constructor stub
    }

    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new ClearScreen(getModel().getTurtle());
    }
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return null;
    }

}
