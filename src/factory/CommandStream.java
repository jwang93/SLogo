package factory;

import java.util.LinkedList;


public class CommandStream {

    private LinkedList<String> commandStream = new LinkedList<String>();

    public CommandStream (LinkedList<String> commands) {
        commandStream = commands;
    }

    public String peek () {
        return commandStream.peek();
    }

    public String remove () {
        return commandStream.remove();
    }

    public boolean isEmpty () {
        return commandStream.isEmpty();
    }

    public void add (String param) {
        commandStream.add(param);
    }

}
