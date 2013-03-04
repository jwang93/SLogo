package factory;

import java.util.HashMap;
import java.util.Map;
import model.Model;
import commands.ICommand;


public class ParserInitializer {

    private Model myModel;
    private Parser myParser;
    public ParserInitializer (Model model, Parser parser) {
        myModel = model;
        myParser = parser;
    }

    protected Map<String, AbstractInitializer> initializeMap () {
        Map<String, AbstractInitializer> map = new HashMap<String, AbstractInitializer>();
        map.put( "fd", new ForwardInitializer(myModel, myParser));
        map.put( "forward", new ForwardInitializer(myModel, myParser));
        map.put( "rt", new RightInitializer(myModel, myParser));
        map.put( "right", new RightInitializer(myModel, myParser));
        map.put("repeat", new RepeatInitializer(myModel, myParser));
        return map;
    }

}
