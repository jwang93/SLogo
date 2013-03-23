package model.scope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import commands.ICommand;
import exceptions.VariableNotFoundException;
import factory.UserFunctionMetaData;


public class MethodScope implements Serializable {
    
    public MethodScope(){
        myUserFunctions = new HashMap<String, UserFunctionMetaData>();
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Map<String, UserFunctionMetaData> myUserFunctions;
    
    public void add(UserFunctionMetaData data){
        myUserFunctions.put(data.getFunctionName(), data);
    }
    public UserFunctionMetaData get(String name){
        return myUserFunctions.get(name);
    }
    public boolean containsKey (String keyword) {
        return myUserFunctions.containsKey(keyword);
    }

}
