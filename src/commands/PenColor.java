package commands;
import model.ITurtle;
public class PenColor extends AbstractZeroParameterTurtleCommand {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PenColor (ITurtle turtle) {
        super(turtle);
    }
    
    public int execute(){
        //TODO is this implemented yet?
        //return getTurtle().getColor();
        return 0; 
        
    }
    
}
