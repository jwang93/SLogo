package factory;

public class CommandInfo {

    String myName;
    public String getName () {
        return myName;
    }

    public int getNumArgs () {
        return myNumArgs;
    }

    int myNumArgs;
    
    public CommandInfo (String clazzname, int numArgs) {
        myName = clazzname;
    }

}
