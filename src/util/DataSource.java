package util;

import java.util.Iterator;


public interface DataSource {
    public Iterator<Paintable> getPaintableIterator ();
}
