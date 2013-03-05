package commands;

import java.util.List;
import exceptions.VariableNotFoundException;


public class Repeat extends CommandList implements ICommand {
    public static final int NUM_ARGS = 2;
    /*
     * The parser parses variabes in order, so the syntax of a repeat statement,
     * repeat [parameter] [codeblock], is reflected in the ordering of the
     * parameters in its parameter list. Unfortunately these must be maintained
     * by the developer if a new parser is written
     * 
     * I don't think Duvall would like this. Wish I understood reflection...
     */
    private static final int INDEX_OF_PARAMETER = 0;
    private static final int INDEX_OF_CODE_BLOCK = 1;
    private int myParameter;
    private ICommand myCodeBlock;

    public Repeat (List<ICommand> parameters) {
        super(parameters);
    }

    @Override
    /**
     * overridden because execute is a funny command
     * Execute the <code>repeat<code>'s code block 
     * <code>parameter<code> number of times.
     * @return the return value of the last command executed. 
     * This is enforced by the return value of <code>CommandList<code>
     */
    public int execute () throws VariableNotFoundException {
        resolveParameters();
        int returnValue = 0;
        for (int i = 0; i < myParameter; i++) {
            returnValue = myCodeBlock.execute();
        }
        return returnValue;

    }

    @Override
    public String toString () {
        return "repeat " + getCommands().get(INDEX_OF_PARAMETER) + " [ " +
               getCommands().get(INDEX_OF_CODE_BLOCK) + "]";
    }

    private void resolveParameters () {
        List<ICommand> commands = getCommands();

        try {
            myParameter = commands.get(INDEX_OF_PARAMETER).execute();
        }
        catch (VariableNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myCodeBlock = commands.get(INDEX_OF_CODE_BLOCK);
    }

}
