package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.ShowTurtle;
import exceptions.FormattingException;


public class ShowTurtleInitializer extends AbstractInitializer {

    public ShowTurtleInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        return new ShowTurtle(getModel().getTurtle());
    }

    /*
     * This class is so simple theres really no need to implement this
     */
    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return null;
    }

}
