package factory;

import java.util.HashMap;
import java.util.Map;
import commands.ICommand;


public class ParserInitializer {

    public ParserInitializer () {
        // TODO Auto-generated constructor stub
    }

    protected Map<String, CommandInfo> initializeMap () {
        Map<String, CommandInfo> map = new HashMap<String, CommandInfo>();
        map.put( "fd", new CommandInfo("forward", 1));
        return map;
    }

}
