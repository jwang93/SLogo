package factory;

public class CommandInfo {

    String myName;
    int myNumArgs;
    
    public String getName () {
        return myName;
    }

    public int getNumArgs () {
        return myNumArgs;
    }
    
    public CommandInfo (String clazzname, int numArgs) {
        myName = clazzname;
    }

}
