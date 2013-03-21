package commands;

import java.util.List;

/**
 * Yea this is getting ridiculous. This is more evidence that i need to refactor.
 * @author Will Nance
 *
 */
public abstract class AbstractFourParameterCommand extends CommandList {
    private static final int FIRST_PARAMETER_INDEX = 0;
    private static final int SECOND_PARAMETER_INDEX = 1;
    private static final int THIRD_PARAMETER_INDEX = 2;
    private static final int FOURTH_PARAMETER_INDEX = 3;
    private static final int NUM_ARGS = 4;
    private int myFirstParameter;
    private int mySecondParameter;
    private int myThirdParameter;
    private int myFourthParameter;

    public AbstractFourParameterCommand (List<ICommand> parameters) {
        super(parameters);
    }

    protected void resolveParameters () {
        setFirstParameter();
        setSecondParameter();
        setThirdParameter();
        setFourthParameter();
    }
    
    
    
    private void setThirdParameter () {
        myThirdParameter = getCommands().get(THIRD_PARAMETER_INDEX).execute();
    }

    private void setFirstParameter () {
        myFirstParameter = getCommands().get(FIRST_PARAMETER_INDEX).execute();
    }
    private void setSecondParameter () {
        mySecondParameter = getCommands().get(SECOND_PARAMETER_INDEX).execute();
    }
    private void setFourthParameter () {
        myFourthParameter = getCommands().get(FOURTH_PARAMETER_INDEX).execute();
    }    

    protected int getFirstParameter () {
        return myFirstParameter;
    }

    protected int getSecondParameter () {
        return mySecondParameter ;
    }

    protected int getThirdParameter () {
        return myThirdParameter;
    }

    protected int getFourthParameter () {
        return myFourthParameter;

    }

}
