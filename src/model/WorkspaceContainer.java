package model;

import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import util.DataSource;
import util.Location;
import util.Paintable;

public class WorkspaceContainer implements DataSource {

    Map<Integer, Workspace> myWorkspaceMap = new HashMap<Integer, Workspace>();
    
    public WorkspaceContainer () {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Iterator<Paintable> getPaintableIterator () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getReturnValue () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Location getTurtlePosition () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getTurtleHeading () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String showMessage () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image getBackgroundImage () {
        // TODO Auto-generated method stub
        return null;
    }

}