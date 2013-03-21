package factory;

import java.util.List;
import model.Model;
import commands.AbstractZeroParameterTurtleCommand;
import commands.Home;
import commands.ICommand;
import exceptions.FormattingException;


public class HomeInitializer extends AbstractInitializer {

    public HomeInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(AbstractZeroParameterTurtleCommand.NUM_ARGS);
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
        return new Home(getModel().getTurtle());
    }

    /**
     * This initializer is so simple there's no need to even implement this function.
     */
    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return null;
    }

}
