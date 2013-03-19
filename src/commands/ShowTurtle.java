package commands;

import model.Turtle;

public class ShowTurtle extends AbstractZeroParameterTurtleCommand implements ICommand {
    public static final int NUM_ARGS =0;
    public ShowTurtle (Turtle turtle) {
        super(turtle);
    }
    
    
    public int execute(){
        return getTurtle().showTurtle();
        
    }

}
