package factory;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.CommandList;
import commands.Constant;
import commands.ICommand;
import commands.Variable;
import exceptions.FormattingException;


/**
 * <p>
 * This class contains a lot of utility parsing functions for initializers in general as well as a
 * framework for creating simple commands, as well as overriding abilities to construct more complex
 * objects
 * </p>
 * <p>
 * The main method called from the parser is build which takes a stream of slogo token strings. THe
 * primary function of an initializer class is to resolve all necessary arguments to construct a
 * function. Arguments are grouped in two ways, either in the parameters for the actual SLogo
 * command, which may be a constant, a list of commands, a nested function, or a variable, or
 * command specific (implicit) arguments, such as a turtle for commands that affect the turtle, or a
 * scope for variables that deal with variables.
 * </p>
 * <p>
 * The framework in this abstract class provides a system for processing the first kind, the
 * explicit slogo parameters, through a recursive algorithm that can handle arbitrarily complex
 * nested syntax. Build calls processParameters which loops a number of times equal to the number of
 * explicit slogo arguments a command takes (defined as a constant in the subclass). process
 * parameters returns a list of ICommands which are to be passed into instantiate, an abstract
 * function responsible for returning a constructed command.
 * </p>
 * 
 * @author Will Nance
 * 
 */
public abstract class AbstractInitializer {
    protected static final String VARIABLE_REGEX = ":[a-zA-z]+";
    protected static final String BEGIN_CODE_BLOCK = "[";
    protected static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";
    private static final String CONSTANT_REGEX = "[-]?[0-9]+";
    private Parser myParser;

    private Model myModel;
    private int numArgs;
    private List<ICommand> myParameters = new ArrayList<ICommand>();

    protected List<ICommand> getParameters () {
        return myParameters;
    }

    public AbstractInitializer (Model model, Parser parser) {
        myModel = model;
        myParser = parser;

    }

    protected void add (ICommand command) {
        myParameters.add(command);
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
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        List<ICommand> parameters = processParameters(commandStream);
        return instantiate(parameters);
    }

    /**
     * <p>
     * This will process the appropriate number of parameters given the specific subclass's number
     * of arguments, <code>NUM_ARGS</code>. This uses a helper method <code>processParameter</code>
     * which handles the different forms which parameters may take.
     * </p>
     * <p>
     * This Function is written to guarantee that a parameter is either successfully parsed or it
     * will throw an exception.
     * </p>
     * 
     * @param commands a list, the head of which is the parameter to be parsed next
     * @return a list of parameters to be passed into an object at construction
     * @throws FormattingException if the user can't code (or there are bugs)
     */
    protected List<ICommand> processParameters (CommandStream commands) throws FormattingException {
        for (int i = 0; i < numArgs; i++) {
            int startLength = myParameters.size();
            processParameter(commands);
            if (!(myParameters.size() > startLength))
                throw new FormattingException(String.format("Could not resolve parameter %d when parsing %s", i+1, this.getClass().getName()));
        }
        return myParameters;
    }

    /**
     * <p>
     * Helper method for <code>processParameters</code> which takes the LinkList of command strings
     * and resolves the parameter to either a <code>Constant</code>, <code>Variable</code>,
     * <code>List</code> or a nested <code>ICommand</code>
     * </p>
     * <p>
     * This code is supposed to be comprehensive enough that it can process most kinds of SLogo
     * parameters (meaning something that will eventually become a number at execution,) but for
     * more complex commands (repeat , if , to) , one can override this function and cherry pick
     * from the helper methods to parse what they need
     * </p>
     * 
     * @param commandStream a list, the head of which is the parameter to be parsed next
     * @throws FormattingException if the commands were improperly formatted
     */
    protected void processParameter (CommandStream commandStream)
                                                                 throws FormattingException {
        if (parseList(commandStream)) return;
        if (parseVariable(commandStream)) return;
        if (parseNestedFunction(commandStream)) return;
        if (parseConstant(commandStream)) return;

    }

    protected boolean parseConstant (CommandStream commandStream) {
        String next = commandStream.peek();
        if (next.matches(CONSTANT_REGEX)) {
            next = commandStream.remove();
            try {
                myParameters.add(new Constant(Integer.parseInt(next)));
                return true;
            }
            catch (java.lang.NumberFormatException e) {
                return false;
                // This was supposed to be a constant and it wasn't
                // This shouldn't happen due to regex check, but processParameters() will
                // do a check and will notice if a parameter wasn't added and throw an exception;
            }
        }
        return false;
    }

    protected boolean parseNestedFunction (CommandStream commandStream)
                                                                       throws FormattingException {
        String next = commandStream.peek();
        if (next.matches(COMMAND_REGEX)) {
            myParameters.add(myParser.parseOnce(commandStream));
            return true;
        }
        return false;
    }

    /**
     * Instantiate the object, given the parameters resolved during parsing and the
     * any other state which the <code>ICommand<code> will require.
     * 
     * @param parameters a list of parameters to be passed into the constructor
     * @return the created <code>ICommand<code>
     */

    protected boolean parseList (CommandStream commandStream) throws FormattingException {
        String next = commandStream.peek();
        if (next.equals(BEGIN_CODE_BLOCK)) {
            // first element is a bracket, remove it
            commandStream.remove();
            CommandList codeBlock = new CommandList();
            while (!commandStream.peek().equals("]")) {
                codeBlock.add(myParser.parseOnce(commandStream));
                if(commandStream.peek() == null) throw new FormattingException("Formatting Error: please check syntax");
            }
            myParameters.add(codeBlock);
            // remove the last bracket
            commandStream.remove();
            return true;
        }
        return false;
    }

    /**
     * Create a <code>Variable<code> object according to the name passed
     * in. This method should remove the prefix.
     * 
     * @param commandStream
     * @return
     */
    protected boolean parseVariable (CommandStream commandStream) {
        String next = commandStream.peek();
        if (next.matches(VARIABLE_REGEX)) {
            String varName = commandStream.remove();
            String variableName = varName.substring(1);
            myParameters.add(new Variable(variableName, myModel));
            return true;
        }
        return false;
    }

    protected abstract ICommand instantiate (List<ICommand> parameters);

    protected void setNumArgs (int numArgs) {
        this.numArgs = numArgs;
    }

    protected int getNumArgs () {
        return numArgs;
    }

    protected Model getModel () {
        return myModel;
    }

    protected Parser getParser () {
        return myParser;
    }

}
