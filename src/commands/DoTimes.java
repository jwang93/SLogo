package commands;

import java.util.List;
import model.scope.Scope;


public class DoTimes extends AbstractSingleParameterCommand {

    /**
     * 
     */
    private static final int INDEX_OF_CODE_BLOCK = 0;
    private String myVarName;
    private ICommand myNumTimes;
    private Scope myScope;

    public DoTimes (List<ICommand> parameters, String varName, ICommand numTimes, Scope scope) {
        super(parameters);
        myVarName = varName;
        myNumTimes = numTimes;
        myScope = scope;
    }

    @Override
    public int execute () {
        resolveParameters();
        int ret = 0;
        for (int i = 0; i < myNumTimes.execute(); i++) {
            myScope.setVariable(myVarName, i);
            ret = getCommands().get(INDEX_OF_CODE_BLOCK).execute();
        }

        return ret;
    }

    @Override
    public String toString () {
        return "dotimes [ :" + myVarName + " " + myNumTimes.toString() + " ] " +
               getCommands().get(INDEX_OF_CODE_BLOCK).toString();
    }

}
