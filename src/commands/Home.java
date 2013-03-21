package commands;

import model.ITurtle;


public class Home extends AbstractZeroParameterTurtleCommand implements ICommand {

    public Home (ITurtle turtle) {
        super(turtle);
    }

    @Override
    public int execute () {
        return getTurtle().home();
    }

}
