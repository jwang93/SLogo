package factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import model.Model;
import commands.CommandList;
import commands.ICommand;
import exceptions.FormattingException;


public class Parser {
    private static final String END_OF_CODE_BLOCK = "]";
    private Map<String, AbstractInitializer> myInitializers;
    private Map<String, ICommand> myUserFunctions;
    private Model myModel;

    public Parser (Model model) {
        myUserFunctions = new HashMap<String, ICommand>();
        myModel = model;
        ParserInitializer init = new ParserInitializer(myModel, this);
        myInitializers = init.initializeMap();
    }

    public ICommand parse (String command) throws FormattingException {
        LinkedList<String> params = new LinkedList<String>();
        for (String str : command.split("\\s+")) {
            params.add(str);
        }
        return parse(params);
    }

    protected ICommand parse (LinkedList<String> commandStream) throws FormattingException {
        CommandList main = new CommandList();
        while (!commandStream.isEmpty()) {
            String keyword = commandStream.remove();
            if (keyword.equals(END_OF_CODE_BLOCK))
                return main;
            if (myUserFunctions.containsKey(keyword)) {
                main.add(myUserFunctions.get(keyword));
                continue;
            }
            AbstractInitializer init = myInitializers.get(keyword);
            main.add(init.build(commandStream));
        }
        return main;
    }

}
