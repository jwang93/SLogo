package main;

import model.Model;
import view.View;

/**
 * Starts the program.
 * @author David Winegar
 *
 */
final class Main {

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
        View view = new View("SLogo", "English");
        Model model = new Model(view);              
        view.setModel(model);
    }

}
