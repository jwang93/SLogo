package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.XCor;

public class XCorInitializer extends AbstractInitializer {

    public XCorInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(XCor.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new XCor(getModel().getTurtle());
    }

}
