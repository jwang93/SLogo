package commands;

import java.io.Serializable;


/**
 * This is a container for a constant in SLogo representing
 * a single interger which it returns on execution.
 * 
 * @author Will Nance
 * 
 */
public class Constant implements ICommand, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int myNum;

    public Constant (int num) {
        myNum = num;
    }

    @Override
    public int execute () {
        return myNum;
    }

    @Override
    public String toString () {
        return "" + myNum;
    }

}
