package factory;

import java.util.HashMap;
import java.util.Map;
import model.Model;


/**
 * This is a helper class that hides the repetitive nature of setting up the initializers
 * for the parser to use.
 * 
 * @author Will Nance
 * 
 */
public class ParserInitializer {

    private Model myModel;
    private Parser myParser;

    public ParserInitializer (Model model, Parser parser) {
        myModel = model;
        myParser = parser;
    }

    /**
     * Create and return the map of initializers for use by the parser
     * 
     * @return a mapping of keywords to the associated object initializer
     */
    protected Map<String, AbstractInitializer> initializeMap () {
        Map<String, AbstractInitializer> map = new HashMap<String, AbstractInitializer>();
        map.put("fd", new ForwardInitializer(myModel, myParser));
        map.put("forward", new ForwardInitializer(myModel, myParser));
        map.put("rt", new RightInitializer(myModel, myParser));
        map.put("right", new RightInitializer(myModel, myParser));
        map.put("repeat", new RepeatInitializer(myModel, myParser));
        map.put("make", new MakeInitializer(myModel, myParser));
        return map;
    }

}
