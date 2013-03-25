
package commands;

import java.util.List;
import model.IModel;

/*Kinda funky and tricky to understand. The single parameter is actually a list of all of the 
 * turtle indices (or other commands), but youre not really sure how many you get.*/
public class Tell extends AbstractSingleParameterCommand implements ICommand {
      
    /**
     * 
     */
    private IModel myModel;

    public Tell ( List<ICommand> parameters, IModel model) {
        super(parameters);
        myModel = model;
    }
    
    
    public int execute(){
        List<ICommand> listOfTurtleIndices = getCommands();
        int[] TurtleInts = new int[listOfTurtleIndices.size()];
        // I hate arrays so much
        for(int i = 0 ; i< listOfTurtleIndices.size(); i++){
            TurtleInts[i]=listOfTurtleIndices.get(i).execute();
        }
        return myModel.getTurtle().setActiveTurtles(TurtleInts);
    }
    
    

}

