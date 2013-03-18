package commands;

import java.util.List;
import model.Scope;
import exceptions.VariableNotFoundException;
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

    public UserFunction (List<ICommand> parameters, UserFunctionMetaData data, Scope scope) {
        myData = data;
        setCommands(parameters);
        myScope = scope;
    }

    public int execute () throws VariableNotFoundException {

        setVariables();
        return super.execute();
    }

    private void setVariables () throws VariableNotFoundException {
        List<String> varNames = myData.getVarNames();
        List<ICommand> commands = getCommands();
        for (int i = 0; i < myData.getNumArgs(); i++) {
            String key = varNames.get(i);
            ICommand value = commands.remove(0);
            myScope.setVariable(key, value.execute());
        }
    }

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
