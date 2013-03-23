package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WorkspaceContainer {

    Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    Workspace myCurrentWorkspace;
    Model myModel;
    Dimension myDefaultCanvasBounds;
    List<Image> myBackgroundImages = new ArrayList<Image>();
    List<Image> myTurtleImages = new ArrayList<Image>();
    List<Color> myColors = new ArrayList<Color>();

    public WorkspaceContainer (Dimension canvasBounds, Model model) {
        myModel = model;
        myDefaultCanvasBounds = canvasBounds;
        switchToWorkspace(0);
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
    
    public void addBackgroundImage (Image image) {
        
    }
    
    public void addTurtleImage (Image image) {
        
    }

}
