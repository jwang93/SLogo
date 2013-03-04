package commands;

import java.util.List;
import model.Turtle;


public class Right extends AbstractTurtleCommand {
    public static final int NUM_ARGS = 1;
    private double myAngle;

    public Right (List<ICommand> commands, Turtle turtle) {
        super(commands, turtle);
    }

    @Override
    public int execute () {

        return 0; // TODO fixme
    }

}
