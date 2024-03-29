package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import model.Model;
import model.scope.MethodScope;
import commands.CommandList;
import commands.Constant;
import commands.ICommand;
import commands.Variable;
import exceptions.FormattingException;


public class Parser {
    private static final String CONSTANT_REGEX = "[-]?[0-9]+";
    private static final String END_OF_CODE_BLOCK = "]";
    private static final String TOKEN_SEPARATOR_REGEX = "\\s+";
    private MethodScope myUserFunctions;
    private Model myModel;
    private static final Class<?>[] INITIALIZER_PARAMETER_TYPES = { Model.class, Parser.class };
    private static final String BUNDLE_NAME = "Initializers";
    private static final String DEFAULT_RESOURCE_PACKAGE = "view.resources.";
    private static final String VARIABLE_REGEX = AbstractInitializer.VARIABLE_REGEX;
    private ResourceBundle myResourceBundle;

    public Parser (Model model) {
        // myUserFunctions = new HashMap<String, UserFunctionMetaData>();
        myModel = model;
        myResourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + BUNDLE_NAME);
    }

    /**
     * pre-method which takes a string of logo commands and calls the main parse
     * methodd with the newly created CommandStream
     * 
     * @param command a string of Logo commands to be parsed
     * @return an ICommand representing the commands that were passed in
     * @throws FormattingException if the parser breaks whie parsing
     */
    public ICommand parse (String command) throws FormattingException {
        myUserFunctions = myModel.getMethodScope();
        CommandStream params = new CommandStream();
        String commandString = command.trim();
        for (String str : commandString.split(TOKEN_SEPARATOR_REGEX)) {
            params.add(str);
        }
        return parse(params);
    }

    /**
     * This function takes a command stream parses the entire stream of commands, and returns
     * an executable ICommand whose head is the start of a program parsed.
     * 
     * @param commandStream
     * @return an ICommand representing the commands that were passed in
     * @throws FormattingException
     */
    protected ICommand parse (CommandStream commandStream) throws FormattingException {
        CommandList main = new CommandList();
        while (!commandStream.isEmpty()) {
            main.add(parseOnce(commandStream));
        }
        return main;
    }

    /**
     * this takes input from a stream of commands and parses a single command or expression
     * and returns the command representing that expression
     * 
     * @param commandStream
     * @return
     * @throws FormattingException
     */
    protected ICommand parseOnce (CommandStream commandStream) throws FormattingException {

        String keyword = commandStream.remove();
        if (keyword.matches(CONSTANT_REGEX))
            return new Constant(Integer.parseInt(keyword));
        if (keyword.matches(VARIABLE_REGEX))
            return new Variable(keyword.substring(1), myModel);
        if (myUserFunctions.containsKey(keyword)) {
            AbstractInitializer init =
                    new UserFunctionInitializer(myModel, this, myUserFunctions.get(keyword));
            return init.build(commandStream);
        }
        if (!myResourceBundle.containsKey(keyword))
            throw new FormattingException(
                                          String.format("Error: The Parser didnt recognize the command %s",
                                                        keyword));
        AbstractInitializer init = getInitializer(myResourceBundle.getString(keyword));
        return init.build(commandStream);
    }

    /**
     * This is actually only 3 lines of code but apparently reflection throws millions of
     * exceptions.
     * This method takes the name of an abstract initializer class and returns an instance of that
     * class.
     * 
     * @param string the name of an abstract initializer
     * @return an instance of the passed in <code>AbstractInitializer</code>
     * @throws FormattingException
     */
    private AbstractInitializer getInitializer (String string) throws FormattingException {
        try {
            Class<?> theClass = Class.forName(string.trim());
            try {
                Constructor<?> constructor = theClass.getConstructor(INITIALIZER_PARAMETER_TYPES);
                try {
                    return (AbstractInitializer) constructor.newInstance(myModel, this);
                }
                catch (IllegalArgumentException e) {
                    throw new FormattingException(
                                                  "Formatting Error: Encountered Illegal Argument Exception");
                }
                catch (InstantiationException e) {
                    throw new FormattingException(
                                                  "Formatting Error: Encountered Instantiation Exception");
                }
                catch (IllegalAccessException e) {
                    throw new FormattingException(
                                                  "Formatting Error: Encountered Illegal Access Exception");
                }
                catch (InvocationTargetException e) {
                    throw new FormattingException(
                                                  "Formatting Error: Encountered Invocation target Exception");
                }
            }

            catch (SecurityException e) {
                throw new FormattingException("Formatting Error: Encountered Security Exception");
            }

            catch (NoSuchMethodException e) {
                throw new FormattingException();
            }

        }
        catch (ClassNotFoundException e) {
            throw new FormattingException();
        }
    }

    /**
     * Called by the initializer for userfunctions. This function takes a
     * UserFunctionMetaData object containing information about the most recently
     * created user function and adds it to the parser's map of known user functions
     * to aid it in parsing calls to those userfunctons later.
     * 
     * @param metadata
     */
    public void add (UserFunctionMetaData metadata) {
        myModel.getMethodScope().add(metadata);
    }

}
