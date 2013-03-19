package factory;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.ICommand;
import commands.To;
import exceptions.FormattingException;


public class ToInitializer extends AbstractInitializer {
    String myFunctionName;
    List<String> myVariableNames;

    public ToInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(To.NUM_ARGS);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {

        return new To(parameters, myFunctionName, getModel().getScope(), getModel().getMethods(),
                      getParser(), myVariableNames);
    }

    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        myFunctionName = processFunctionName(commandStream);
        myVariableNames = processVariableNames(commandStream);
        if (parseList(commandStream) == false) throw new FormattingException();
        changeParserState();
        return instantiate(getParameters());
    }

    private void changeParserState () {
        Parser parser = getParser();
        ICommand codeBlock = getParameters().get(0);
        parser.add(new UserFunctionMetaData(myFunctionName, myVariableNames, codeBlock));

    }

    protected String processFunctionName (CommandStream commandStream)
                                                                      throws FormattingException {
        String next = commandStream.remove();
        if (!next.matches(COMMAND_REGEX)) throw new FormattingException();
        return next;

    }

    protected List<String> processVariableNames (CommandStream commandStream)
                                                                             throws FormattingException {
        List<String> variableNames = new ArrayList<String>();
        String next = commandStream.remove();
        if (!next.equals(BEGIN_CODE_BLOCK)) throw new FormattingException();
        while (!commandStream.peek().equals("]")) {
            String varName = commandStream.remove();
            if (!varName.matches(VARIABLE_REGEX)) throw new FormattingException();
            variableNames.add(varName.substring(1));
        }
        // remove the bracket
        commandStream.remove();
        return variableNames;
    }

}
