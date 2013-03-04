package commands;

/**
 * This is a container for a constant in SLogo representing 
 * a single interger which it returns on execution.
 * @author Will Nance
 *
 */
public class Constant implements ICommand {
    private int myNum;
    
    public Constant (int num) {
        myNum = num;
    }

    @Override
    public int execute () {
        return myNum;
    }

}
