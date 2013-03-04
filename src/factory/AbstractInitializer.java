package factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Model;
import commands.Constant;
import commands.ICommand;
import commands.Variable;
import exceptions.FormattingException;


public abstract class AbstractInitializer {
    private static final String VARIABLE_PREFIX = ":";
    private static final String BEGIN_LIST = "[";
    private Parser myParser;
    private Model myModel;
    private int numArgs;

    public AbstractInitializer (Model model, Parser parser) {
        myModel = model;
        myParser = parser;

    }

    /**
     * This is the class's central method. Creating commands is a two step process.
     * First you resolve the parameters of the command, and then you instantiate
     * the command with the parameters. Instantiation obviously varies for different
     * commands, but overriding it in the subclass also gives you freedom to pass
     * in other special parameters that the object may require at runtime.
     * 
     * @param commandStream a list, the head of which is the parameter to be parsed next
     * @return an ICommand object to be added to the program while compiling
     * @throws FormattingException if the user is stupid (or if there are bugs)
     */
    protected ICommand build (LinkedList<String> commandStream) throws FormattingException {
        List<ICommand> parameters = processParameters(commandStream);
        return instantiate(parameters);
    }

    /**
     * This will process the appropriate number of parameter given
     * the specific subclasses number of arguments, <code>NUM_ARGS<code>.
     * This uses a helper method <code>processParameter<code>which 
     * handles the different forms
     * which parameters may take.
     * 
     * @param commandStream a list, the head of which is the parameter to be parsed next
     * @return a list of parameters to be bassed into an object at construction
     * @throws FormattingException if the user is stupid (or there are bugs)
     */
    protected List<ICommand> processParameters (LinkedList<String> commandStream)
                                                                                 throws FormattingException {
        List<ICommand> parameters = new ArrayList<ICommand>();
        for (int i = 0; i < numArgs; i++) {
            parameters.add(processParameter(commandStream));
        }
        return parameters;

    }

    /**
     * Helper method for <code>processParameters<code> which 
     * takes the LinkList of command strings and resolves the 
     * parameter to either a <code>Constant<code>, <code>Variable<code>, <code>List<code>
     * or a nested <code>ICommand<code>
     * 
     * @param commandStream a list, the head of which is the parameter to be parsed next
     * @return
     * @throws FormattingException
     */
    protected ICommand processParameter (LinkedList<String> commandStream)
                                                                          throws FormattingException {
        String next = commandStream.peek();
        if (next.equals(BEGIN_LIST)) return parseList(commandStream);
        if (next.startsWith(VARIABLE_PREFIX)) return parseVariable(commandStream.remove());
        // TODO handle nested functions

        // next is a constant number
        next = commandStream.remove();
        try {
            return new Constant(Integer.parseInt(next));
        }
        catch (java.lang.NumberFormatException e) {
            throw new FormattingException();

        }

    }

    /**
     * Instantiate the object, given the parameters resolved during parsing and the
     * any other state which the <code>ICommand<code> will require.
     * 
     * @param parameters a list of parameters to be passed into the constructor
     * @return the created <code>ICommand<code>
     */
    protected abstract ICommand instantiate (List<ICommand> parameters);

    protected ICommand parseList (LinkedList<String> commands) throws FormattingException {
        // first element is a bracket, remove it
        commands.remove();
        return myParser.parse(commands);
    }

    /**
     * Create a <code>Variable<code> object according to the name passed
     * in. The name must have the prefix removed.
     * 
     * @param commandStream
     * @return
     */
    protected ICommand parseVariable (String varName) {
        String variableName = varName.substring(VARIABLE_PREFIX.length());
        return new Variable(variableName, myModel);
    }

    protected void setNumArgs (int numArgs) {
        this.numArgs = numArgs;
    }

    protected int getNumArgs () {
        return numArgs;
    }

    protected Model getModel () {
        return myModel;
    }

}