package factory;

import java.util.List;
import commands.ICommand;


public class UserFunctionMetaData {
    String myFunctionName;
    ICommand myCodeBlock;
    int myNumArgs;
    List<String> myVarNames;

    public UserFunctionMetaData (String functionName,
                                 List<String> variableNames,
                                 ICommand codeBlock) {
        myFunctionName = functionName;
        myCodeBlock = codeBlock;
        myVarNames = variableNames;
        myNumArgs = myVarNames.size();
    }

    protected String getFunctionName () {
        return myFunctionName;
    }

    protected void setFunctionName (String myFuntionName) {
        myFunctionName = myFuntionName;
    }

    protected ICommand getMyCodeBlock () {
        return myCodeBlock;
    }

    protected void setCodeBlock (ICommand myCodeBlock) {
        this.myCodeBlock = myCodeBlock;
    }

    protected int getNumArgs () {
        return myNumArgs;
    }

    protected void setNumArgs (int myNumArgs) {
        this.myNumArgs = myNumArgs;
    }

    protected List<String> getVarNames () {
        return myVarNames;
    }

    protected void setVarNames (List<String> myVarNames) {
        this.myVarNames = myVarNames;
    }

}
