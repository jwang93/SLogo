package commands;

import java.util.List;
import model.Scope;


public class Make extends AbstractSingleParameterCommand implements ICommand {
    // don't count the variable name, just the number -- "make varname expression"
    public static final int NUM_ARGS = 1;
    private Scope myScope;
    private String myName;

    public Make (List<ICommand> parameters, String varName, Scope scope) {
        super(parameters);
        myName = varName;
        myScope = scope;
    }

    @Override
    public int execute () {
        resolveParameters();
        myScope.setVariable(myName, getOnlyParameter());
        return getOnlyParameter();
    }

    @Override
    public String toString () {
        return "make :" + myName + " " + getCommands().get(0);
    }

}
