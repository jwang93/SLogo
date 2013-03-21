package commands;

import java.util.List;
import model.scope.MethodScope;
import model.scope.Scope;
import factory.Parser;


public class To extends AbstractSingleParameterCommand implements ICommand {
    public static final int NUM_ARGS = 1;
    private List<String> myVariableNames;
    private String myName;
    private MethodScope myMethods;

    public To (List<ICommand> parameters,
               String methodName,
               Scope scope,
               MethodScope methods,
               Parser parser,
               List<String> variableNames) {

        super(parameters);
        myVariableNames = variableNames;
        myName = methodName;
        myMethods = methods;
    }

    @Override
    public int execute () {
        CommandList codeBlock = new CommandList();
        for (ICommand command : getCommands()) {
            codeBlock.add(command);
        }
        myMethods.setVariable(myName, codeBlock);
        return 1;

    }

}
