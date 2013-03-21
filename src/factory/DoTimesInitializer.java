package factory;

import java.util.List;
import model.Model;
import commands.*;
import exceptions.FormattingException;

/**
 * This is a single parameter command because I dont count the special syntax at the beginning 
 * of the command
 * @author Will Nance
 *
 */
public class DoTimesInitializer extends AbstractInitializer {
    private String myVarName;
    private ICommand myNumTimes;
    
    public DoTimesInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(DoTimes.NUM_ARGS);
    }
    
    /**
     * overriding because dotimes has special syntax that must be dealt with
     */
    @Override
    public ICommand build(CommandStream commands) throws FormattingException{
        parseConditions(commands);
        return super.build(commands);
        
    }
    /**
     * This method parses the special syntax associated with the dotimes command.
     * It takes input in the form of "[ :varname expression ] and sets
     * state variables so that the name of the variable and the expression
     * can be passed to the command.
     * @param commands
     * @throws FormattingException
     */
    private void parseConditions (CommandStream commands) throws FormattingException {
        if(! commands.peek().equals("[")) throw new FormattingException("Dotimes was incorrrectly formatted");
        commands.remove();
        if(!commands.peek().matches(VARIABLE_REGEX))throw new FormattingException("Dotimes was incorrrectly formatted");
        myVarName =  commands.remove().substring(1);
        myNumTimes = getParser().parseOnce(commands);
        if( !commands.peek().equals("]"))  throw new FormattingException("Dotimes was incorrrectly formatted");
        commands.remove();
    }
    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new DoTimes(parameters, myVarName, myNumTimes, getModel().getScope() );
    }

}
