package commands;

import java.util.List;
import model.scope.MethodScope;
import model.scope.Scope;
import factory.Parser;


public class To extends AbstractSingleParameterCommand implements ICommand {
    public static final int NUM_ARGS = 1;
    private List<String> myVariableNames;
    private String myName;

    public To (List<ICommand> parameters,
               String methodName,
               Scope scope,
               Parser parser,
               List<String> variableNames) {

        super(parameters);
        myVariableNames = variableNames;
        myName = methodName;
    }

    @Override
    public int execute () {
        CommandList codeBlock = new CommandList();
        for (ICommand command : getCommands()) {
            codeBlock.add(command);
        }
        return 1;

    }

}
