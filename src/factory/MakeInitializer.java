package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Make;
import exceptions.FormattingException;


public class MakeInitializer extends AbstractInitializer {

    private String myName;

    public MakeInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Make.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Make(parameters, myName, getModel().getScope());
    }

    @Override
    protected ICommand build (CommandStream commandStream) throws FormattingException {
        myName = processVarName(commandStream);
        List<ICommand> parameters = processParameters(commandStream);
        return instantiate(parameters);
    }

    protected String processVarName (CommandStream commandStream) throws FormattingException {
        String next = commandStream.peek();
        if (!next.matches(VARIABLE_REGEX))
            throw new FormattingException();
        return commandStream.remove().substring(1);
    }

    @Override
    /**
     * same as super except make shouldn't accept a list as an argument so leave that out.
     */
    protected void processParameter (CommandStream commandStream) throws FormattingException {
        if (parseVariable(commandStream)) return;
        if (parseNestedFunction(commandStream)) return;
        if (parseConstant(commandStream)) return;

    }

}
