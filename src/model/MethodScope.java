package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import commands.ICommand;
import exceptions.VariableNotFoundException;


public class MethodScope implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Stack<Map<String, ICommand>> myScope = new Stack<Map<String, ICommand>>();
    private Map<String, ICommand> myCurrentScope;

    public MethodScope () {
        myScope.push(new HashMap<String, ICommand>());
        resetCurrentScope();
    }

    /**
     * This method works exactly how you think it does. <br/>
     * 
     * @param varName
     * @return the value of the variable
     * @throws VariableNotFoundException
     */
    public ICommand get (String varName) throws VariableNotFoundException {
        if (!myCurrentScope.containsKey(varName))
            throw new VariableNotFoundException();
        return myCurrentScope.get(varName);
    }

    public void setVariable (String varName, ICommand commandList) {
        myCurrentScope.put(varName, commandList);
    }

    /**
     * Add an empty scope to the stack. none of the old outer
     * variables will be visible. this is for things like
     * a function call in which there is no persistence
     * of variables
     */
    public void newScope () {
        myScope.push(new HashMap<String, ICommand>());
        resetCurrentScope();
    }

    /**
     * Adds a scope to the stack but copies all variables in the old scope into
     * the new scope. This is for things like <code>repeat<code> loops that may 
     * need to keep track of a temporary value like an index. When the loop 
     * completes it can pop the stack and the scope will be as it was but
     * without the variables declared in the inner loop.
     */
    public void newInnerScope () {
        HashMap<String, ICommand> newScope = new HashMap<String, ICommand>();
        newScope.putAll(myCurrentScope);
        myScope.push(newScope);
        resetCurrentScope();
    }

    /**
     * Helper method to make sure that the current scope is updated
     * to reflect changes in the stack of scopes.
     * Should be called by any method that alters <code>myScope<code>
     */
    private void resetCurrentScope () {
        myCurrentScope = myScope.peek();
    }

    /**
     * Pops current scope and goes back to the outer scope.
     */
    public void exitScope () {
        myScope.pop();
        resetCurrentScope();
    }

}
