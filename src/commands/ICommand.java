package commands;

import exceptions.VariableNotFoundException;

public interface ICommand {
    public int execute () throws VariableNotFoundException;
}
