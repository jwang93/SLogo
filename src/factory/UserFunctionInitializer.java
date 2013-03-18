package factory;

import java.util.List;

import model.Model;
import commands.*;
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
        return new UserFunction(parameters, myData, getModel().getScope() )
;    }
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        addVariables( commandStream);
        return instantiate(getParameters());
    }

    /**
     * Running User Defined Functions requires that you add the method parameters to the scope.
     * This function appends to the beginning of the function's code block some <code>Make<code> commands which will create
     * the variables at runtime. When a user function is run, it will first run the make commands
     * to set the UserFunction's parameters, then it will run the code associated with the user
     * function. This function creates the make commands and then adds them to the parameter list. 
     * @param commandStream
     * @throws FormattingException
     */
    protected void addVariables (CommandStream commandStream) throws FormattingException {
        StringBuilder makeCommands = new  StringBuilder();
        for(String varName : myVariableNames){
            makeCommands.append(String.format("make :%s %s", varName, getParser().parseOnce(commandStream).toString()));
        }
        if(myVariableNames.size()>0)
            myCommands.add(super.getParser().parse(makeCommands.toString()));
        add(myCommands);
        add(myCodeBlock);
    }

}
