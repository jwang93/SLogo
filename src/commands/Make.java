package commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Model;
import model.scope.Scope;


public class Make extends AbstractSingleParameterCommand implements ICommand {

    // don't count the variable name, just the number -- "make varname expression"
    public static final int NUM_ARGS = 1;
    private Scope myScope;
    private String myName;
    private Model myModel;

    public Make (List<ICommand> parameters, String varName, Scope scope, Model model) {
        super(parameters);
        myName = varName;
        myScope = scope;
        myModel = model;
    }

    @Override
    public int execute () {
        resolveParameters();
        myScope.setVariable(myName, getOnlyParameter());
        toSessionFile();
        return getOnlyParameter();
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

    @Override
    public String toString () {
        return "make :" + myName + " " + getCommands().get(0);
    }

}
