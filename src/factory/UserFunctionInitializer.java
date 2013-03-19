package factory;

import java.util.List;
import model.Model;
import commands.CommandList;
import commands.ICommand;
import commands.UserFunction;
import exceptions.FormattingException;


public class UserFunctionInitializer extends AbstractInitializer {

    private ICommand myCodeBlock;
    private List<String> myVariableNames;
    private CommandList myCommands = new CommandList();
    private UserFunctionMetaData myData;

    public UserFunctionInitializer (Model model, Parser parser, UserFunctionMetaData data) {
        super(model, parser);
        myData = data;
        setNumArgs(data.getNumArgs());
        myVariableNames = data.getVarNames();
        myCodeBlock = data.getMyCodeBlock();
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new UserFunction(parameters, myData, getModel().getScope());
    }

    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        addVariables(commandStream);
        return instantiate(getParameters());
    }

    /**
     * Running User Defined Functions requires that you add the method parameters to the scope.
     * This function appends to the beginning of the function's code block some ICommands which will
     * be
     * assigned to variables at runtime. When a user function is run. This function creates the
     * parameters that will serve as method arguments. It also adds the CodeBlock that will actually
     * get run.
     * 
     * @param commandStream
     * @throws FormattingException
     */
    protected void addVariables (CommandStream commandStream) throws FormattingException {

        for (String varName : myVariableNames) {
            processParameter(commandStream);
        }
        add(myCodeBlock);
    }

}
