package factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Model;
import commands.Constant;
import commands.ICommand;
import exceptions.FormattingException;


public abstract class AbstractInitializer {
    private Parser myParser;
    private Model myModel;
    private int numArgs;

    protected void setNumArgs (int numArgs) {
        this.numArgs = numArgs;
    }

    protected int getNumArgs () {
        return numArgs;
    }

    protected Model getModel () {
        return myModel;
    }

    public AbstractInitializer (Model model, Parser parser) {
        myModel = model;
        myParser = parser;

    }

    protected ICommand build (Iterator<String> iter) throws FormattingException{
        List<ICommand> parameters = processParameters(iter);
        return instantiate(parameters);
    }

    protected abstract ICommand instantiate (List<ICommand> parameters);

    protected List<ICommand> processParameters (Iterator<String> iter) throws FormattingException{
        List<ICommand> parameters = new ArrayList<ICommand>();
        for (int i = 0; i < numArgs; i++) {
            parameters.add(processParameter(iter));
        }
        return parameters;

    }

    protected ICommand parseList (Iterator<String> commandStream) {

        return null;
    }

    protected ICommand parseVariable (String varName) {

        return null;
    }

    protected ICommand processParameter(Iterator<String> iter) throws FormattingException {
        String next = iter.next();
        if(next.equals("["))
               return myParser.parse(iter);
        // next is a constant number
        return new Constant(Integer.parseInt(next));

    }

}
