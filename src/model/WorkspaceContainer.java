package model;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import model.scope.MethodScope;


public class WorkspaceContainer {

    Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    Workspace myCurrentWorkspace;
    Model myModel;
    Dimension myDefaultCanvasBounds;
    private MethodScope myMethods;

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
        
    }
    
    public void addTurtleImage (Image image) {
        


    }

}
