package factory;

import java.util.LinkedList;
import java.util.List;
import commands.ICommand;
import model.Model;
import exceptions.FormattingException;
import factory.AbstractInitializer;

public class ToInitializer extends AbstractInitializer {

    public ToInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        // TODO Auto-generated method stub
        return null;
    }
    protected ICommand build (LinkedList<String> commandStream) throws FormattingException {
        processFunctionName( commandStream);
        List<ICommand> parameters = processParameters(commandStream);
        return instantiate(parameters);
    }
    protected void processParameter (LinkedList<String> commandStream)throws FormattingException {
        
    }
    protected String processFunctionName(LinkedList<String> commandStream) throws FormattingException{
        String next = commandStream.remove();
        if(! next.matches(COMMAND_REGEX)){
            throw new FormattingException();
        }
        return next;
        
        
    }
    protected List<String> processVariableNames(LinkedList<String> commandStream){
        return commandStream;
        
    }
        

}
