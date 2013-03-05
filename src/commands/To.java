package commands;

import java.util.Arrays;
import java.util.List;
import factory.Parser;
import model.Scope;

public class To extends AbstractSingleParameterCommand implements ICommand {
    public static final int NUM_ARGS = 1;
    private List<String> myVariableNames;
    private String myName;
    public To (List<ICommand> parameters, String methodName , Scope scope , Parser parser ,  String ... variableNames){
        super(parameters);
        myVariableNames = Arrays.asList(variableNames);
        myName = methodName;
    }
    
    
    public int execute(){
        return 0;
    }
    
    
}
