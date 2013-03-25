package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Pixmap;
import model.scope.MethodScope;


public class WorkspaceContainer {

    Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    Workspace myCurrentWorkspace;
    Model myModel;
    Dimension myDefaultCanvasBounds;

    private MethodScope myMethods;

    List<Image> myBackgroundImages = new ArrayList<Image>();
    List<Pixmap> myTurtleImages = new ArrayList<Pixmap>();
    List<Color> myColors = new ArrayList<Color>();

    public WorkspaceContainer (Dimension canvasBounds, Model model) {
        myModel = model;
        myDefaultCanvasBounds = canvasBounds;
        switchToWorkspace(0);
        myMethods = new MethodScope();
    }

    public Workspace getCurrentWorkspace () {
        return myCurrentWorkspace;
    }

    public void switchToWorkspace (int workspaceNumber) {
        if (!myWorkspaceMap.containsKey(workspaceNumber)) {
            Workspace workspace = new Workspace(myDefaultCanvasBounds);
            myWorkspaceMap.put(workspaceNumber, workspace);
            myCurrentWorkspace = workspace;
        }
        else {
            myCurrentWorkspace = myWorkspaceMap.get(workspaceNumber);
        }
    }

    public MethodScope getMethods(){
        return myMethods;
    }
    
    public void addBackgroundImage (Image image) {
        myBackgroundImages.add(image);
    }
    
    public void addTurtleImage (Image image) {
        myTurtleImages.add(new Pixmap(image));
    }
    
    public Pixmap getTurtleImage (int index) {
        return myTurtleImages.get(index);
    }
    
    public Image getBackgroundImage (int index) {
        return myBackgroundImages.get(index);
    }

}