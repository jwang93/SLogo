package commands;

public abstract class AbstractCommandCollection implements ICommand {

       /**
        * represents a collection of commands to be executed. This is the base class for 
        * anything that involves multiple commands, including if statements and 
        * repeat commands, which can have a block of commands to be executed.
        * This can also be used to make the custom commands that the user enters 
        */
    public AbstractCommandCollection () {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int execute () {
        // TODO Auto-generated method stub
        return 0;
    }

}
