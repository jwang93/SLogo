package factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import commands.ICommand;
import model.Model;
import exceptions.FormattingException;
import factory.AbstractInitializer;
import commands.To;


public class ToInitializer extends AbstractInitializer {
    int myNumArgs = To.NUM_ARGS;
    String myFunctionName;
    List<String> myVariableNames;

    public ToInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        String[] array = new String[myVariableNames.size()];
        for(int i =0 ; i< myVariableNames.size() ; i++){array[i] = myVariableNames.get(i);} 
        return new To(parameters, myFunctionName, getModel().getScope(), getParser() ,array);
    }

    protected ICommand build (LinkedList<String> commandStream) throws FormattingException {
        myFunctionName = processFunctionName(commandStream);
        myVariableNames = processVariableNames(commandStream);
        List<ICommand> parameters = processParameters(commandStream);
        changeParserState();
        return instantiate(parameters);
    }

    private void changeParserState () {
        
        Parser parser = getParser();
        ICommand codeBlock = getParameters().get(0);
        parser.add(new UserFunctionMetaData(myFunctionName, myVariableNames, codeBlock ));
        
    }

   

    protected String processFunctionName (LinkedList<String> commandStream)
                                                                           throws FormattingException {
        String next = commandStream.remove();
        if (!next.matches(COMMAND_REGEX)) { throw new FormattingException(); }
        return next;

    }

    protected List<String> processVariableNames (LinkedList<String> commandStream)
                                                                                  throws FormattingException {
        List<String> variableNames = new ArrayList<String>();
        String next = commandStream.remove();
        if (!next.equals(BEGIN_CODE_BLOCK)) { throw new FormattingException(); }
        while (!commandStream.peek().equals("]")) {
            String varName = commandStream.remove();
            if (!varName.matches(VARIABLE_REGEX)) { throw new FormattingException(); }
            variableNames.add(varName.substring(1));
        }
        // remove the bracket
        commandStream.remove();
        return variableNames;
    }

}