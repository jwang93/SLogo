
package factory;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.Forward;
import commands.ICommand;
import commands.Tell;
import exceptions.FormattingException;


public class TellInitializer extends AbstractInitializer {

    private ICommand[] myTurtles;

    public TellInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Tell.NUM_ARGS);
    }

//    protected ICommand build (CommandStream commandStream) throws FormattingException {
//        myTurtles = parseTurtles(commandStream);
//        return super.build(commandStream);
//    }
//    private ICommand[] parseTurtles (CommandStream commands) throws FormattingException {
//        if (!commands.peek().equals("[")) throw new FormattingException();
//        commands.remove();
//        List<ICommand> turtles = new ArrayList<ICommand>();
//        
//
//            turtles.add(processParameters(commands));
//        
//    }
    /*This is kind of a hacky way of solving this issue , but it works, and I'm happy with it.*/
    protected List<ICommand> processParameters (CommandStream commands) throws FormattingException {
        if(! commands.peek().equals("[")) throw new FormattingException();
        commands.remove();
        while (!commands.peek().equals("]")) {
            int startLength = myParameters.size();
            processParameter(commands);
            if (!(myParameters.size() > startLength))
                throw new FormattingException(String.format("Tell not formatted correctly"));
        }
        commands.remove();
        return myParameters;
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {

        return new Tell(parameters, getModel());
    }

}
