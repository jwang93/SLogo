package model;

import java.awt.Dimension;

public class Workspace {

    TurtleContainer myTurtleContainer;
    
    public Workspace (Dimension canvasBounds) {
       myTurtleContainer = new TurtleContainer(canvasBounds);
    }

}
