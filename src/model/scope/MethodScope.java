package model.scope;

import java.util.HashMap;
import java.util.Map;
import factory.UserFunctionMetaData;


public class MethodScope {

    public MethodScope () {
        myUserFunctions = new HashMap<String, UserFunctionMetaData>();
    }

    /**
     * 
     */
    private Map<String, UserFunctionMetaData> myUserFunctions;

    public void add (UserFunctionMetaData data) {
        myUserFunctions.put(data.getFunctionName(), data);
    }

    public UserFunctionMetaData get (String name) {
        return myUserFunctions.get(name);
    }

    public boolean containsKey (String keyword) {
        return myUserFunctions.containsKey(keyword);
    }

}
