package commands;

import java.util.List;
import model.Turtle;


public class Left extends AbstractSingleParameterCommand {

    private double myAngle;

    public Left (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();

        /* NOTE ***depending on how angle calculation works, this may not work *** */
        double newHeading = turtle.getHeading() - myAngle;

        turtle.setHeading(newHeading);
        return (int) newHeading;  // returns the new direction turtle is pointing it
    }

}
