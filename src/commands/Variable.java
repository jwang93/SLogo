package commands;

import model.Model;


public class Variable implements ICommand {

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
