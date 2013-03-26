package model.workspaces;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Paintable;
import util.Pixmap;

/**
 * Represents a simple immutable paintable image in the model.
 * @author David Winegar
 *
 */
public class Stamp implements Paintable {

    private Pixmap myImage;
    private Location myLocation;
    private Dimension mySize;

    /**
     * sets the image, location, and size (cannot be changed)
     * @param image image to use
     * @param location location of image
     * @param size size of image
     */
    public Stamp (Pixmap image, Location location, Dimension size) {
        myImage = image;
        myLocation = location;
        mySize = size;
    }

    @Override
    public void paint (Graphics2D pen) {
        myImage.paint(pen, myLocation, mySize);
    }

}
