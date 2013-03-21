package factory;

import java.util.List;
import model.Model;
import commands.AbstractZeroParameterTurtleCommand;
import commands.ICommand;
import commands.PenUp;
import exceptions.FormattingException;


public class PenUpInitializer extends AbstractInitializer {

    public PenUpInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(AbstractZeroParameterTurtleCommand.NUM_ARGS);
    }

    /*
     * Overriding because using the AbstractInitializer functionality
     * here would be like using a Tank when a golf cart would do.
     * 
     * p.s. you can take my word for it that you COULD use
     * the abstract initializer here if you wanted. . .
     */

    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new PenUp(getModel().getTurtle());
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return null;
    }

}
