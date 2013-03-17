package factory;

import java.util.ArrayList;
import java.util.List;
import commands.ICommand;


/**
 * This is a container class for the data structure in which we store a command's parameters
 * It has limited functionality but provides the flexibility to extend behaivor if the
 * specifications of the parameters change in some way.
 * </br>
 * 
 * This is used as the intermediary class which is passed from an initializer class to the command
 * which it is initializing. The objects stored in this list will be removed and used at runtime.
 * 
 * @author Will Nance
 * 
 */
public class ParameterContainer {

    private List<ICommand> parameters = new ArrayList<ICommand>();

    public ParameterContainer () {
    }

    /**
     * remove and return the first element
     * 
     * @return the first element
     */
    public ICommand remove () {
        return parameters.remove(0);
    }

    public void add (ICommand command) {
        parameters.add(command);
    }

    public ICommand get (int i) {
        return parameters.get(i);
    }
}
