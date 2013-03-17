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

        // TURTLE COMMANDS
        map.put("fd", new ForwardInitializer(myModel, myParser));
        map.put("forward", new ForwardInitializer(myModel, myParser));
        map.put("rt", new RightInitializer(myModel, myParser));
        map.put("right", new RightInitializer(myModel, myParser));
        map.put("bk", new BackInitializer(myModel, myParser));
        map.put("back", new BackInitializer(myModel, myParser));
        map.put("lt", new LeftInitializer(myModel, myParser));
        map.put("left", new LeftInitializer(myModel, myParser));

        // VARIABLES, CONTORL STRUCTURES, and USER-DEFINED COMMANDS
        map.put("repeat", new RepeatInitializer(myModel, myParser));
        map.put("make", new MakeInitializer(myModel, myParser));
        map.put("set", new MakeInitializer(myModel, myParser));

        // MATH OPERATIONS
        map.put("sum", new SumInitializer(myModel, myParser));
        map.put("difference", new DifferenceInitializer(myModel, myParser));
        map.put("product", new ProductInitializer(myModel, myParser));
        map.put("quotient", new QuotientInitializer(myModel, myParser));
        map.put("remainder", new RemainderInitializer(myModel, myParser));
        map.put("minus", new MinusInitializer(myModel, myParser));
        map.put("random", new RandomInitializer(myModel, myParser));

        // TURTLE QUERIES
        map.put("xcor", new XCorInitializer(myModel, myParser));
        map.put("ycor", new YCorInitializer(myModel, myParser));
        map.put("heading", new HeadingInitializer(myModel, myParser));

        return map;
    }

}
