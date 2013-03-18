package factory;

import java.util.LinkedList;


public class CommandStream {

    private LinkedList<String> myCommandStream;

    public CommandStream () {
        myCommandStream = new LinkedList<String>();
    }

    public CommandStream (LinkedList<String> commands) {
        myCommandStream = commands;
    }

    public String peek () {
        return myCommandStream.peek();
    }

    public String remove () {
        return myCommandStream.remove();
    }

    public boolean isEmpty () {

        return myCommandStream.isEmpty();
    }

    public void add (String param) {
        myCommandStream.add(param);
    }

}
