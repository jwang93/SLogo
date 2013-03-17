package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import model.Model;
import commands.CommandList;
import commands.ICommand;
import exceptions.FormattingException;


public class Parser {
    private static final String END_OF_CODE_BLOCK = "]";
    private Map<String, AbstractInitializer> myInitializers;
    private Map<String, UserFunctionMetaData> myUserFunctions;
    private Model myModel;
    private static final Class[] INITIALIZER_PARAMETER_TYPES = { Model.class, Parser.class };
    private static final String BUNDLE_NAME = "Initializers";
    private static final String DEFAULT_RESOURCE_PACKAGE = "view.resources.";
    private ResourceBundle myResourceBundle;

    public Parser (Model model) {
        myUserFunctions = new HashMap<String, UserFunctionMetaData>();
        myModel = model;
        ParserInitializer init = new ParserInitializer(myModel, this);
        myInitializers = init.initializeMap();
        myResourceBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + BUNDLE_NAME);
    }

    public ICommand parse (String command) throws FormattingException {
        CommandStream params = new CommandStream(new LinkedList<String>());
        String commandString = command.trim();
        for (String str : commandString.split("\\s+")) {
            params.add(str);
        }
        return parse(params);
    }

    protected ICommand parseOnce (CommandStream commandStream) throws FormattingException {
        String keyword = commandStream.remove();
        if (keyword.equals(END_OF_CODE_BLOCK))
            return new CommandList();
        if (!myInitializers.containsKey(keyword)) throw new FormattingException();
        AbstractInitializer init = getInitializer(myResourceBundle.getString(keyword));
        return init.build(commandStream);
    }

    protected ICommand parse (CommandStream commandStream) throws FormattingException {
        CommandList main = new CommandList();
        while (!commandStream.isEmpty()) {
            main.add(parseOnce(commandStream));
        }
        return main;
    }

    private AbstractInitializer getInitializer (String string) throws FormattingException {
        try {
            System.out.println(string);
            Class<?> theClass = Class.forName(string);
            try {
                Constructor<?> constructor = theClass.getConstructor(INITIALIZER_PARAMETER_TYPES);
                try {
                    return (AbstractInitializer) constructor.newInstance(myModel, this);
                }
                catch (IllegalArgumentException e) {
                    System.out.println(1);
                    throw new FormattingException();
                }
                catch (InstantiationException e) {
                    System.out.println(2);
                    throw new FormattingException();
                }
                catch (IllegalAccessException e) {
                    System.out.println(3);
                    throw new FormattingException();
                }
                catch (InvocationTargetException e) {
                    System.out.println(4);
                    throw new FormattingException();
                }
            }

            catch (SecurityException e) {
                System.out.println(5);
                throw new FormattingException();
            }

            catch (NoSuchMethodException e) {
                System.out.println(6);
                throw new FormattingException();
            }

        }
        catch (ClassNotFoundException e) {
            System.out.println(7);
            throw new FormattingException();
        }
    }

    public void add (UserFunctionMetaData metadata) {
        myUserFunctions.put(metadata.getFunctionName(), metadata);
        // myInitializers.put( metadata.getFunctionName(), new UserFunctionInitializer( myModel,
        // this , metadata));

    }

}
