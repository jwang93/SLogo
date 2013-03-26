package model.workspaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Pixmap;


/**
 * This is the container for the Workspaces. It contains a map of all the workspaces and all shared
 * resources, which includes the list of colors, background iamges, and Turtle images.
 * 
 * @author David Winegar
 * 
 */
public class WorkspaceContainer {

    private Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    private Workspace myCurrentWorkspace;
    private Dimension myDefaultCanvasBounds;
    private List<Image> myBackgroundImages = new ArrayList<Image>();
    private List<Pixmap> myTurtleImages = new ArrayList<Pixmap>();
    private List<Color> myColors = new ArrayList<Color>();

    /**
     * adds default images/colors and starts a new workspace with ID 0.
     * 
     * @param canvasBounds default bounds of canvas
     */
    public WorkspaceContainer (Dimension canvasBounds) {
        // first image is default turtle image
        myTurtleImages.add(Turtle.DEFAULT_IMAGE);
        // first image is no image (just colored background)
        myBackgroundImages.add(null);
        // first color is black
        myColors.add(Color.BLACK);
        myDefaultCanvasBounds = canvasBounds;
        switchToWorkspace(0);
    }

    /**
     * Returns the current workspace.
     * 
     * @return Workspace currently being used
     */
    public Workspace getCurrentWorkspace () {
        return myCurrentWorkspace;
    }

    /**
     * If workspace exists, switch to it, if not, creates it.
     * 
     * @param workspaceNumber ID of workspace
     */
    public void switchToWorkspace (int workspaceNumber) {
        if (!myWorkspaceMap.containsKey(workspaceNumber)) {
            Workspace workspace = new Workspace(myDefaultCanvasBounds, this);
            myWorkspaceMap.put(workspaceNumber, workspace);
            myCurrentWorkspace = workspace;
        }
        else {
            myCurrentWorkspace = myWorkspaceMap.get(workspaceNumber);
        }
    }

    /**
     * Adds a background image to be used and sets it as the current background image.
     * 
     * @param image to be used.
     */
    public void addBackgroundImage (Image image) {
        myBackgroundImages.add(image);
        getCurrentWorkspace().setBackgroundImage(myBackgroundImages.indexOf(image));
    }

    /**
     * Adds a turtle image to be used and sets it as the current background image.
     * 
     * @param image to be used.
     */
    public void addTurtleImage (Image image) {
        myTurtleImages.add(new Pixmap(image));
        getCurrentWorkspace().setShape(myTurtleImages.indexOf(image));
    }

    /**
     * Adds a color to be used.
     * 
     * @param index of new color
     * @param color to be used
     */
    public void addColor (int index, Color color) {
        myColors.add(index, color);
    }

    /**
     * gets turtle image at index
     * @param index of turtle image
     * @return image of turtle
     */
    protected Pixmap getTurtleImage (int index) {
        return myTurtleImages.get(index);
    }
    
    /**
     * gets background image at index
     * @param index of background image
     * @return image of background
     */
    protected Image getBackgroundImage (int index) {
        return myBackgroundImages.get(index);
    }

    /**
     * returns a color at the given index
     * 
     * @param index of color
     * @return color value
     */
    protected Color getColor (int index) {
        return myColors.get(index);
    }

}
