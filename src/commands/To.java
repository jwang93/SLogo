package commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Model;
import model.scope.MethodScope;
import model.scope.Scope;
import factory.Parser;


public class To extends AbstractSingleParameterCommand implements ICommand {
    public static final int NUM_ARGS = 1;
    private List<String> myVariableNames;
    private String myName;
    private CommandList codeBlock;
    private Model myModel;
    
    private static final String TO_TOKEN_ONE = "to ";
    private static final String TO_TOKEN_TWO = " [ ";
    private static final String TO_TOKEN_THREE = " ] [ ";
    private static final String TO_TOKEN_FOUR = " ] ";
    private static final String COLON = ":";
    private static final String WHITE_SPACE = " ";



    public To (List<ICommand> parameters,
               String methodName,
               Scope scope,
               Parser parser,
               List<String> variableNames,
               Model model) {

        super(parameters);
        myVariableNames = variableNames;
        myName = methodName;
        myModel = model;
    }

    @Override
    public int execute () {
        codeBlock = new CommandList();
        for (ICommand command : getCommands()) {
            codeBlock.add(command);
        }
        toSessionFile();
        return 1;
    }
    
    @Override
    public String toString () {
        String ret = TO_TOKEN_ONE + myName + TO_TOKEN_TWO;
        for (String variableName : myVariableNames) ret += COLON + variableName + WHITE_SPACE;
        ret += TO_TOKEN_THREE;
        for (ICommand command : codeBlock.getCommands()) ret += command.toString();
        ret += TO_TOKEN_FOUR;
        return ret;
    }
    
    private void toSessionFile () {
        try {
            FileWriter tempFileWriter = myModel.getFileWriter();
            tempFileWriter.write(toString() + System.getProperty("line.separator"));
            tempFileWriter.flush();
            myModel.setFileWriter(tempFileWriter);
        }
        catch (IOException e) {
            e.printStackTrace();
        }        
    }

}
