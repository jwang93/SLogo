package factory;

import java.util.List;
import model.Model;
import commands.HideTurtle;
import commands.ICommand;
import commands.ShowTurtle;
import exceptions.FormattingException;

public class HideTurtleInitializer extends AbstractInitializer {

    public HideTurtleInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(ShowTurtle.NUM_ARGS);
    }
    
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new HideTurtle(getModel().getTurtle());
    }
    
    /*
     *This class is so simple theres really no need to implement this 
     *see documentation on the ClearScreeninitializer
     */
    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return null;
    }

}
