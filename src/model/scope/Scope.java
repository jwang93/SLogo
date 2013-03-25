package model.scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import exceptions.VariableNotFoundException;


/**
 * <p>
 * This class represents a variable scope in SLogo. I don't know if we'll get around to implementing
 * it properly but the functionality is here to do it.
 * </p>
 * <p>
 * You can use it as a map from variable names to their corresponding integer value but the
 * underlying implementation of a stack of maps actually gives you the ability to manage the scope
 * by pushing and popping new scopes on to it. Method calls will create a brand new scope, while
 * commands which contain code blocks such as repeat, if, if else which have a scope of their own
 * but also access to variables that were visible outside of their block of code can call
 * newInnerScope() to retain their functionality.
 * </p>
 * <br/>
 * 
 * @author Will Nance
 * 
 * 
 */
public class Scope {
    /**
     * 
     */
    private static final int DEFAULT_VARIABLE_VALUE = 0;
    private Stack<Map<String, Integer>> myScope = new Stack<Map<String, Integer>>();
    private Map<String, Integer> myCurrentScope;

    public Scope () {
        myScope.push(new HashMap<String, Integer>());
        resetCurrentScope();
    }

    /**
     * This method works exactly how you think it does. <br/>
     * 
     * @param varName
     * @return the value of the variable
     * @throws VariableNotFoundException
     */
    public int get (String varName) {
        if (!myCurrentScope.containsKey(varName))
            return DEFAULT_VARIABLE_VALUE;
        return myCurrentScope.get(varName);
    }

    public void setVariable (String varName, int value) {
        myCurrentScope.put(varName, value);
    }

    /**
     * Add an empty scope to the stack. none of the old outer
     * variables will be visible. this is for things like
     * a function call in which there is no persistence
     * of variables
     */
    public void newScope () {
        myScope.push(new HashMap<String, Integer>());
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
        HashMap<String, Integer> newScope = new HashMap<String, Integer>();
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
