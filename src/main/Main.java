package main;

import view.View;
import model.Model;

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
