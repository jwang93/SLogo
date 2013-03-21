package model;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Iterator;
import model.scope.MethodScope;
import model.scope.Scope;
import util.DataSource;
import util.Location;
import util.Paintable;


public class Workspace implements DataSource {

    TurtleContainer myTurtleContainer;
    private Scope myScope;
    private MethodScope myMethods;

    public Workspace (Dimension canvasBounds) {
        myTurtleContainer = new TurtleContainer(canvasBounds);
        myScope = new Scope();
        myMethods = new MethodScope();
    }

    public ITurtle getTurtle () {
        return myTurtleContainer;
    }

    public Scope getScope () {
        return myScope;
    }

    public MethodScope getMethodScope () {
        return myMethods;
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
