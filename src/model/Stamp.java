package model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Paintable;
import util.Pixmap;

public class Stamp implements Paintable {
    
    Pixmap myImage;
    Location myLocation;
    Dimension mySize;

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
