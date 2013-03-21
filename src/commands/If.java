package commands;

import java.util.List;


public class If extends CommandList implements ICommand {

    public static final int NUM_ARGS = 2;
    private ICommand myTest;
    private ICommand myCodeBlock;

    public If (List<ICommand> parameters) {
        super(parameters);
        myTest = getCommands().remove(0);
        myCodeBlock = getCommands().remove(0);
    }

    @Override
    public int execute () {
        if (myTest.execute() == 1) return myCodeBlock.execute();
        return 0;

    }

}
