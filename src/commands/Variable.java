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
        // TODO Auto-generated method stub
        return 0;
    }

}
