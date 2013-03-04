package commands;

import java.util.ArrayList;
import java.util.List;
import model.Turtle;
import util.Vector;


public class Forward extends CommandList {
    public static final int NUM_ARGS =1;
    
    
    List<ICommand> myParameters = new ArrayList<ICommand>();


    private Turtle myTurtle;

    public Forward (List<ICommand> commands, Turtle turtle) {
        super(commands);
        myTurtle = turtle;
        
    }

    @Override
    public int execute () {
       
        return 0;
        
    }
    

}
