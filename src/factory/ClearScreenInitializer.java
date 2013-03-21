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

    /*
     * Overriding because using the AbstractInitializer functionality
     * here would be like using a Tank when a golf cart would do.
     * 
     * p.s. you can take my word for it that you COULD use
     * the abstract initializer here if you wanted. . .
     */
    /**
     * Returns a new instance of a Home command
     * 
     * @return a new Home command.
     */
    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new ClearScreen(getModel().getTurtle());
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return null;
    }

}
