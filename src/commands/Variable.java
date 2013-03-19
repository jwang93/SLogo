package commands;

import java.io.Serializable;
import model.Model;


public class Variable implements ICommand, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String myName;
    private Model myModel;

    public Variable (String name, Model model) {
        myName = name;
        myModel = model;
    }

    @Override
    public int execute () {
        return myModel.getScope().get(myName);
    }

    @Override
    public String toString () {
        return ":" + myName;
    }

}
