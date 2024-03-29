package model.workspaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.scope.MethodScope;
import model.scope.Scope;
import util.Location;
import util.Pixmap;


/**
 * This is a workspace. It represents all the data of all the turtles to the view through the
 * DataSource interface and all the Turtle actions to the Commands through the ITurtle interface.
 * 
 * @author David Winegar
 * 
 */
public class Workspace implements DataSource, ITurtle {

    private Scope myScope;
    private MethodScope myMethods;

    private Map<Integer, Turtle> myTurtles = new HashMap<Integer, Turtle>();
    private List<Turtle> myActiveTurtles = new ArrayList<Turtle>();
    private Dimension myCanvasBounds;
    private int myReturnValue;
    private int myBackgroundImageIndex = 0;
    private int myTurtleImageIndex = 0;
    private int myPenColorIndex = 0;
    private int myBackgroundColorIndex = 0;
    private WorkspaceContainer myContainer;

    /**
     * Creates the workspace and adds the scopes and adds the first turtle at ID 0.
     * 
     * @param canvasBounds bounds of canvas
     * @param container workspaceContainer used for global lists of things like images
     */
    public Workspace (Dimension canvasBounds, WorkspaceContainer container) {
        myScope = new Scope();
        myMethods = new MethodScope();
        myContainer = container;
        myCanvasBounds = canvasBounds;

        setActiveTurtles(0);

    }

    /**
     * returns the variable scope
     * 
     * @return variable scope
     */
    public Scope getScope () {
        return myScope;
    }

    /**
     * returns the method scope
     * 
     * @return method scope
     */
    public MethodScope getMethodScope () {
        return myMethods;
    }

    /**
     * Sets the return value for DataSource
     * 
     * @param returnValue of command
     */
    public void setReturnValue (int returnValue) {
        myReturnValue = returnValue;
    }

    @Override
    public int getReturnValue () {
        return myReturnValue;
    }

    @Override
    public int getTurtleHeading () {
        return (int) getLastActiveTurtle().getHeading();
    }

    @Override
    public Image getBackgroundImage () {
        return myContainer.getBackgroundImage(myBackgroundImageIndex);
    }

    @Override
    public void paint (Graphics2D pen) {
        for (Turtle turtle : myTurtles.values()) {
            turtle.paint(pen);
        }
    }

    @Override
    public Color getBackgroundColor () {
        return myContainer.getColor(myBackgroundColorIndex);
    }

    @Override
    public Map<String, Integer> getUserVariables () {
        // todo: it will return a map representing with variable name as keys and value as value
        return null;
    }

    @Override
    public Map<String, String> getUserFunctions () {
        // todo: it will return a map representing with function name as keys and string
        // representing the function as value
        return null;
    }

    @Override
    public void toggleHighlighter () {
        for (Turtle turtle : getActiveTurtles()) {
            turtle.toggleTurtleHighlighter();
        }
    }

    @Override
    public Location getTurtlePosition () {
        return getLastActiveTurtle().getTurtlePosition();
    }

    private List<Turtle> getActiveTurtles () {
        return myActiveTurtles;
    }

    @Override
    public int move (int pixels) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.move(pixels);
        }
        return i;
    }

    @Override
    public int turn (int degrees) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = (int) turtle.turn(degrees);
        }
        return i;
    }

    @Override
    public int setHeading (int heading) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = (int) turtle.setHeading(heading);
        }
        return i;
    }

    @Override
    public int towards (Location location) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = (int) turtle.towards(location);
        }
        return i;
    }

    @Override
    public int setLocation (Location location) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.setLocation(location);
        }
        return i;
    }

    @Override
    public int showTurtle () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.showTurtle();
        }
        return i;
    }

    @Override
    public int hideTurtle () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.hideTurtle();
        }
        return i;
    }

    @Override
    public int showPen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.showPen();
        }
        return i;
    }

    @Override
    public int hidePen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.hidePen();
        }
        return i;
    }

    @Override
    public int home () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.home();
        }
        return i;
    }

    @Override
    public int clearScreen () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.clearScreen();
        }
        return i;
    }

    @Override
    public int isTurtleShowing () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.isTurtleShowing();
        }
        return i;
    }

    @Override
    public int isPenDown () {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.isPenDown();
        }
        return i;
    }

    @Override
    public int getHeading () {
        return (int) getLastActiveTurtle().getHeading();
    }

    @Override
    public int getX () {
        return (int) getLastActiveTurtle().getX();
    }

    @Override
    public int getY () {
        return (int) getLastActiveTurtle().getY();
    }

    @Override
    public int setBackgroundColor (int colorIndex) {
        Color color = myContainer.getColor(colorIndex);
        if (color == null) return 0;
        myBackgroundColorIndex = colorIndex;
        return colorIndex;
    }

    @Override
    public int setBackgroundImage (int imageIndex) {
        if (myContainer.getBackgroundImage(imageIndex) == null) return 0;
        myBackgroundImageIndex = imageIndex;
        return myBackgroundImageIndex;
    }

    @Override
    public int setPenColor (int colorIndex) {
        Color color = myContainer.getColor(colorIndex);
        if (color == null) return 0;
        for (Turtle turtle : myActiveTurtles) {
            turtle.setPenColor(color);
        }
        return colorIndex;
    }

    @Override
    public int setPenSize (int pixels) {
        int i = 0;
        for (Turtle turtle : getActiveTurtles()) {
            i = turtle.setPenSize(pixels);
        }
        return i;
    }

    @Override
    public int setShape (int shapeIndex) {
        Pixmap image = myContainer.getTurtleImage(shapeIndex);
        if (image == null) return 0;
        myTurtleImageIndex = shapeIndex;
        for (Turtle turtle : myActiveTurtles) {
            turtle.setView(image);
        }
        return myTurtleImageIndex;
    }

    @Override
    public int setPalette (int colorIndex, int red, int green, int blue) {
        myContainer.addColor(colorIndex, new Color(red, green, blue));
        return colorIndex;
    }

    @Override
    public int getPenColor () {
        return myPenColorIndex;
    }

    @Override
    public int stamp () {
        for (Turtle turtle : getActiveTurtles()) {
            turtle.stamp();
        }
        return 0;
    }

    @Override
    public int clearStamps () {
        for (Turtle turtle : getActiveTurtles()) {
            turtle.clearStamps();
        }
        return 0;
    }

    @Override
    public int getShapeIndex () {
        return myTurtleImageIndex;
    }

    @Override
    public int getTurtleID () {
        for (Entry<Integer, Turtle> entry : myTurtles.entrySet()) {
            if (getLastActiveTurtle().equals(entry.getValue())) return entry.getKey();
        }
        return 0;
    }

    @Override
    public int setActiveTurtles (int ... turtleIds) {
        myActiveTurtles = new ArrayList<Turtle>();
        for (int id : turtleIds) {
            if (myTurtles.containsKey(id)) {
                myActiveTurtles.add(myTurtles.get(id));
            }
            else {
                Turtle newTurtle =
                        new Turtle(myCanvasBounds, myContainer.getTurtleImage(myTurtleImageIndex));
                myTurtles.put(id, newTurtle);
                myActiveTurtles.add(newTurtle);
            }
        }
        return turtleIds[turtleIds.length - 1];
    }

    @Override
    public int setAllTurtlesActive () {
        myActiveTurtles = new ArrayList<Turtle>(myTurtles.values());
        return myActiveTurtles.size();
    }

    @Override
    public int makeEvenTurtlesActive () {
        return evenOddHelper(false);
    }

    /**
     * Private helper method that takes a boolean and sets turtles as active according to whether
     * that boolean is true or not.
     */
    private int evenOddHelper (boolean isOdd) {
        int oddOrEven = 0;
        if (isOdd) {
            oddOrEven = 1;
        }
        myActiveTurtles = new ArrayList<Turtle>();
        int lastId = 0;
        for (int id : myTurtles.keySet()) {
            if (id % 2 == oddOrEven) {
                myActiveTurtles.add(myTurtles.get(id));
                lastId = id;
            }
        }
        if (myActiveTurtles.isEmpty()) {
            myActiveTurtles = new ArrayList<Turtle>(myTurtles.values());
        }
        return lastId;
    }

    @Override
    public int makeOddTurtlesActive () {
        return evenOddHelper(true);
    }

    private Turtle getLastActiveTurtle () {
        return getActiveTurtles().get(getActiveTurtles().size() - 1);
    }
}
