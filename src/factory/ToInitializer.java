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

        return new To(parameters, myFunctionName, getModel().getScope(),
                      getParser(), myVariableNames, myModel);
    }

    @Override
    /**
     * This Method is overrided because of the special syntax required for to commands
     * You much remove from the command stream the variable names brackets and function names
     * before parsing. Finally, you must alert the parser at this stage that this user function
     * is valid syntax. 
     */
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        myFunctionName = processFunctionName(commandStream);
        myVariableNames = processVariableNames(commandStream);
        if (parseList(commandStream) == false) throw new FormattingException();
        changeParserState();
        return instantiate(getParameters());
    }
    /**
     * This function adds UserFunctionMetaData to the method scope so that
     * later references to the user-defined function can be parsed.
     */
    private void changeParserState () {
        Parser parser = getParser();
        ICommand codeBlock = getParameters().get(0);
        parser.add(new UserFunctionMetaData(myFunctionName, myVariableNames, codeBlock));

    }

    protected String processFunctionName (CommandStream commandStream)
                                                                      throws FormattingException {
        String next = commandStream.remove();
        if(!next.matches(COMMAND_REGEX)) throw new FormattingException();
        return next;
    }
    /**
     * parses the variable names that will be added to the scope when the user passes
     * parameters into this user defined function. so for to square [ :length ] [ {commands} ]
     * this method would parse [ :length ] and then later when a user says square 50,
     * the function will know to create a variable in the variable scope called :length
     * so that any references to it in {commands} will function properly
     * @param commandStream
     * @return a list of variable names
     * @throws FormattingException
     */
    protected List<String> processVariableNames (CommandStream commandStream)
                                                                             throws FormattingException {
        List<String> variableNames = new ArrayList<String>();
        //remove the bracket
        String next = commandStream.remove();
        if (!next.equals(BEGIN_CODE_BLOCK)) throw new FormattingException();
        //Parse all variable names that will be parameters for this user defined function
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
