package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;


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
    private static final int DEFAULT_GRID_FREQUENCY = 10;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;

    private Image myBackground;
    private Color myBackgroundColor;
    private boolean myGridShowing = true;
    private Grid myGrid;
    private WorkspaceInView myWorkspace;

    /**
     * Create a panel so that it knows its size.
     * 
     * @param size size of the viewable area
     * @param workspace used to paint
     */
    public Canvas (Dimension size, WorkspaceInView workspace) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
        myWorkspace = workspace;
        myGrid =
                new Grid(new Dimension(getWidth(), getHeight()),
                         DEFAULT_GRID_FREQUENCY);
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
        pen.setColor(myBackgroundColor);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        pen.drawImage(myBackground, 0, 0, getSize().width, getSize().height, null);

        if (myGridShowing) {
            myGrid.paint((Graphics2D) pen);
        }
        myWorkspace.paintModel((Graphics2D) pen);
    }

    /**
     * Updates the iterator and repaints.
     * 
     */
    public void update () {
        repaint();
    }

    /**
     * Used to change size of canvas.
     * 
     * @param size new size of canvas
     */
    public void changeSize (Dimension size) {
        setPreferredSize(size);
        setSize(size);
        repaint();
    }

    /**
     * toggles the grid showing.
     */
    public void toggleGrid () {
        myGridShowing = !myGridShowing;
    }

    /**
     * Sets the background color.
     * 
     * @param color to set
     */
    public void setBackgroundColor (Color color) {
        if (color != null) {
            myBackgroundColor = color;
        }
    }

    /**
     * Sets the background image.
     * 
     * @param image to set
     */
    public void setBackgroundImage (Image image) {
        myBackground = image;
    }

}
