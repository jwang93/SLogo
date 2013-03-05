package commands;

import exceptions.VariableNotFoundException;
import model.Model;

public class Variable implements ICommand {
    
    private String myName;
    private Model myModel;
    public Variable (String name, Model model) {
        myName = name;
        myModel = model;
    }

    @Override
    public int execute () throws VariableNotFoundException {
        try {
            return myModel.getScope().get(myName);
        }
        catch (VariableNotFoundException e) {
            throw new VariableNotFoundException();
        }
        
    }
    public String toString(){
        return ":"+myName;
    }

}
