package main;

import java.awt.Dimension;
import model.Model;
import view.View;


/**
 * Starts the program.
 * 
 * @author David Winegar
 * 
 */
final class Main {

    private static final Dimension CANVAS_BOUNDS = new Dimension(600, 400);

    /**
     * Do not allow instantiation of Main.
     */
    private Main () {
    }

    /**
     * Instantiates Model and View and sets them, starting the program.
     * 
     * @param args input arguments (not used)
     */
    public static void main (String[] args) {
        Model model = new Model(CANVAS_BOUNDS);
        new View("SLogo", "English", model, CANVAS_BOUNDS);
    }

}
