package factory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import commands.ICommand;
import exceptions.FormattingException;


public class Parser {
    Map<String, ICommand> myCommandMap;

    public Parser () {
        ParserInitializer init = new ParserInitializer();
        myCommandMap = init.initializeMap();

    }

    public ICommand parse (String command) throws FormattingException {
        List<String> params = Arrays.asList(command.split("\\s+"));
        Iterator<String> iter = params.iterator();
        String keyword = iter.next();
        if (!myCommandMap.containsKey(keyword))
            throw new FormattingException();
        while (iter.hasNext()) {

        }

        return null;
    }

}
