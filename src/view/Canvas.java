package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import util.Paintable;


/**
 * Creates an area of the screen in which the paintable objects will be drawn.
 * 
 * @author Robert C Duvall
 * @author David Winegar
 * @author Zhen Gou
 */
public class Canvas extends JComponent {
    // default serialization ID
    private static final long serialVersionUID = 1L;

    private Iterator<Paintable> myPaintableIterator;
    private Image myBackground;

    /**
     * Create a panel so that it knows its size.
     * 
     * @param size size of the viewable area
     */
    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // prepare to receive input
        List<Paintable> emptyList = new ArrayList<Paintable>();
        myPaintableIterator = emptyList.iterator();
        
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        pen.drawImage(myBackground, 0, 0, getSize().width, getSize().height, null);
        while (myPaintableIterator.hasNext()) {
            pen.setColor(Color.BLACK);
            Paintable paintable = myPaintableIterator.next();
            paintable.paint((Graphics2D) pen);
        }
    }

    /**
     * Updates the iterator and repaints.
     * 
     * @param iterator iterator to update
     */
    public void update (Iterator<Paintable> iterator, Image backgroundImage) {
        myPaintableIterator = iterator;
        myBackground = backgroundImage;
        repaint();
    }

}
