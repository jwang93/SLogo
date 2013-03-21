package commands;

import java.util.ArrayList;
import java.util.List;
import model.scope.Scope;
import factory.UserFunctionMetaData;


/**
 * User functions can be thought of as basically commandLists that have
 * different toString functions. UserFunctions without parameters run exactly
 * like a CommandList, they loop through the block of code and execute until done. <br/>
 * UserFunctions with parameters are slightly different. They have a number of make commands that
 * are
 * created at compile-time that will set the method variables at runtime. The initializer takes care
 * of
 * creating these make commands, but the toString method must be mindful to print out
 * just the name of the user defined functions and the string representation of its parameters, as
 * opposed
 * to printing the underlying implementation of the method, which is what the superclass's method
 * would do
 * 
 * @author Will Nance
 * 
 */
public class UserFunction extends CommandList implements ICommand {
    private UserFunctionMetaData myData;
    private Scope myScope;
    private List<ICommand> myVariables = new ArrayList<ICommand>();

    public UserFunction (List<ICommand> parameters, UserFunctionMetaData data, Scope scope) {
        myData = data;
        setCommands(parameters);
        myScope = scope;
        setVariables();
    }

    /*
     * The special execute function here is necessary.
     * there are times when you may need to run the same command more than
     * once (such as in a repeat command). Often times one of the parameters
     * that the user function takes in may change. The update variables function will
     * maintain the state of the method instance variables each time it is called.
     */
    @Override
    public int execute () {
        updateVariables();
        return super.execute();
    }

    private void updateVariables () {
        for (int i = 0; i < myVariables.size(); i++) {
            String key = myData.getVarNames().get(i);
            ICommand value = myVariables.get(i);
            myScope.setVariable(key, value.execute());
        }

    }

    private void setVariables () {
        myData.getVarNames();
        List<ICommand> commands = getCommands();
        for (int i = 0; i < myData.getNumArgs(); i++) {
            myVariables.add(commands.remove(0));
        }
    }

    // TODO fix, no make commands any more
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append(myData.getFunctionName() + " ");
        for (int i = 0; i < myData.getNumArgs(); i++) {
            Make make = (Make) getCommands().get(i);
            ICommand command = make.getCommands().get(0);
            sb.append(command.toString());
        }
        return sb.toString();
    }

}
