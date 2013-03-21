package factory;

import java.util.List;
import model.Model;
import commands.*;

public class SetPaletteInitializer extends AbstractInitializer {

    public SetPaletteInitializer (Model model, Parser parser) {
        super(model, parser);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new SetPalette(parameters , getModel());
    }

}
