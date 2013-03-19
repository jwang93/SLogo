package commands;

import util.Location;
import model.Turtle;

public class Home extends AbstractZeroParameterTurtleCommand implements ICommand {


    public Home (Turtle turtle) {
        super(turtle);
    }
    
    public int execute(){
        return getTurtle().setLocation(new Location(0,0));
    }

}
