package commands;

import java.util.List;
import model.Scope;
import commands.CommandList;

public class Make extends CommandList implements ICommand {
    
    private Scope myScope;
    public Make (List<ICommand> parameters, Scope scope) {
        super(parameters);
        myScope = scope;
    }

    @Override
    public int execute () {
        // TODO Auto-generated method stub
        return 0;
    }

}
