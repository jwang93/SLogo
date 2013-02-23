package factory;

import java.util.HashMap;
import java.util.Map;
import commands.ICommand;


public class ParserInitializer {

    public ParserInitializer () {
        // TODO Auto-generated constructor stub
    }

    protected Map<String, ICommand> initializeMap () {
        Map<String, ICommand> map = new HashMap<String, ICommand>();
        return map;
    }

}
