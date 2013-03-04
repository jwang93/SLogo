package util;

import java.util.Iterator;


public interface DataSource {
    public Iterator<Paintable> getPaintableIterator ();

    public int getReturnValue ();

    public Location getTurtlePosition ();

    public int getTurtleHeading ();

    public String showMessage ();

}
