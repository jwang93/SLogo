package commands;

import java.util.List;


public class IfElse extends CommandList implements ICommand {
    public static final int NUM_ARGS = 3;
    private ICommand myTest;
    private ICommand myTrueCodeBlock;
    private ICommand myFalseCodeBlock;

    public IfElse (List<ICommand> parameters) {
        super(parameters);
        myTest = getCommands().remove(0);
        myTrueCodeBlock = getCommands().remove(0);
        myFalseCodeBlock = getCommands().remove(0);
    }

    @Override
    public int execute () {
        if (myTest.execute() == 1) return myTrueCodeBlock.execute();
        return myFalseCodeBlock.execute();
    }

}
