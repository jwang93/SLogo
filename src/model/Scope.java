package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import exceptions.VariableNotFoundException;


public class Scope {
    private Stack<Map<String, Integer>> myScope = new Stack<Map<String, Integer>>();
    private Map<String, Integer> myCurrentScope;

    public Scope () {
        myScope.push(new HashMap<String, Integer>());
        myCurrentScope = myScope.peek();
    }

    public int get (String varName) throws VariableNotFoundException {
        if (!myCurrentScope.containsKey(varName))
            throw new VariableNotFoundException();
        return myCurrentScope.get(varName);
    }

    public void setVariable (String varName, int value) {
        myCurrentScope.put(varName, value);
    }
    /**
     * add an empty scope to the stack. none of the old outer
     * variables will be visible. this is for things like 
     * a function call in which there are no persistence
     * of variables
     */
    public void newScope(){
        myScope.push(new HashMap<String, Integer>());
        resetCurrentScope();
    }
    /**
     * adds a scope to the stack but copies all variables in the old scope into 
     * the new scope. This is for things like <code>repeat<code> loops that may 
     * need to keep track of a temporary value like an index. When the loop 
     * completes it can pop the stack and the scope will be as it was but
     * without the variables declared in the inner loop.
     */
    public void newInnerScope(){
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
    public void exitScope(){
        myScope.pop();
        resetCurrentScope();
    }
}
