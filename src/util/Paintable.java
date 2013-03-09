package util;

import java.awt.Graphics2D;


/**
 * Interface of objects that can be painted using AWT Graphics2D objects.
 * 
 * @author David Winegar
 * 
 */
public interface Paintable {
    /**
     * Paints the current object to the screen.
     * 
     * @param pen pen to paint with
     */
    public void paint (Graphics2D pen);
}
