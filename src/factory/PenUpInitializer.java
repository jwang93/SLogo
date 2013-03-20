package factory;

import java.util.List;
import commands.PenUp;
import model.Model;
import commands.ICommand;
import exceptions.FormattingException;

public class PenUpInitializer extends AbstractInitializer {

    public PenUpInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(PenUp.NUM_ARGS);
    }
    /*
     * Overriding because using the AbstractInitializer functionality 
     * here would be like using a Tank when a golf cart would do.
     * 
     * p.s. you can take my word for it that you COULD use 
     * the abstract initializer here if you wanted. . .
     */
    
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new PenUp(getModel().getTurtle());
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return null;
    }

}
