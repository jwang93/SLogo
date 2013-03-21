package model;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;


public class WorkspaceContainer {

    Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    Workspace myCurrentWorkspace;
    Model myModel;
    Dimension myCanvasBounds;

    public WorkspaceContainer (Dimension canvasBounds, Model model) {
        myModel = model;
        myCanvasBounds = canvasBounds;
        switchToWorkspace(0);
    }

    public Workspace getCurrentWorkspace () {
        return myCurrentWorkspace;
    }

    public void switchToWorkspace (int workspaceNumber) {
        if (!myWorkspaceMap.containsKey(workspaceNumber)) {
            Workspace workspace = new Workspace(myCanvasBounds);
            myWorkspaceMap.put(workspaceNumber, workspace);
            myCurrentWorkspace = workspace;
        }
        else {
            myCurrentWorkspace = myWorkspaceMap.get(workspaceNumber);
        }
    }

}
