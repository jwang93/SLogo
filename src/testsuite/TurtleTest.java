package testsuite;

import java.awt.Dimension;
import junit.framework.TestCase;
import model.Turtle;
import org.junit.Test;
import util.Location;


/**
 * test basic turtle's functionality e.g. move, turn, towards etc.
 * 
 * DOES NOT work after setting Turtle to protected, keep in mind. 
 * Commented out because of this. Passes test if Turtle is set to public.
 * @author Zhen Gou
 * 
 */

public class TurtleTest extends TestCase {
    /**
    private final static Dimension DEFAULT_DIMENSION = new Dimension(600, 400);
    private final static Location HOME_LOCATION = new Location(0, 0);
    private final static double ERROR_LEVEL = 0.0001;
    private Turtle myTurtle;
    
    @Test
    public void testInitialization () {
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        assertEquals(myTurtle.getTurtlePosition(), HOME_LOCATION);

    }

    @Test
    public void testTurn () {
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        myTurtle.turn(30);
        assertEquals(myTurtle.getHeading(), 300.0);
        myTurtle.turn(-200);
        assertEquals(myTurtle.getHeading(), 100.0);
    }

    @Test
    public void testBasicMove () {
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        myTurtle.move(50);
        assertEquals(myTurtle.getTurtlePosition(), new Location(0, 50));
        myTurtle.move(-90);
        assertEquals(myTurtle.getTurtlePosition(), new Location(0, -40));
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        myTurtle.turn(45);
        myTurtle.move(10);
        assertTrue(locationDiffSquare(myTurtle.getTurtlePosition(),
                                      new Location(Math.sqrt(50), Math.sqrt(50))) < ERROR_LEVEL);

    }

    @Test
    public void testSetLocation () {
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        myTurtle.setLocation(new Location(12, 34));
        assertTrue(locationDiffSquare(myTurtle.getTurtlePosition(),
                                      new Location(12, 34)) < ERROR_LEVEL);

    }

    @Test
    public void testTowards () {
        myTurtle = new Turtle(DEFAULT_DIMENSION);
        myTurtle.towards(new Location(10, -10));
        assertEquals(myTurtle.getHeading(), 45.0);
    }

    public double locationDiffSquare (Location one, Location two) {
        return Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y, 2);
    }
    */
}
