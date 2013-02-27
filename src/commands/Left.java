package commands;

import model.Turtle;


public class Left extends AbstractTurtleCommand {

    private double myAngle;

    public Left (Turtle turtle, double angle) {
        super(turtle);
        myAngle = angle;
    }

    @Override
    public int execute () {
        Turtle turtle = getTurtle();
       
        /* NOTE ***depending on how angle calculation works, this may not work ***  */
        double newHeading = turtle.getHeading() - myAngle;  
        
        turtle.setHeading(newHeading);
        return (int) newHeading;  // returns the new direction turtle is pointing it
    }
    
}