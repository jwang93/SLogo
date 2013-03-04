package factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Model;
import model.Turtle;
import commands.Forward;
import commands.ICommand;
import commands.Right;


public class RightInitializer extends AbstractInitializer {
    public RightInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Right.NUM_ARGS);
    }

   
    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Right(parameters, getModel().getTurtle());
    }

    

}
