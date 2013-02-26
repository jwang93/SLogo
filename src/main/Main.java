package main;

import model.Model;
import view.View;

public class Main {

    /**
     * start running the program
     * 
     * @param args
     */
    public static void main (String[] args) {
        Model model = new Model();
        new View("SLogo", model, "English");
    }

}
