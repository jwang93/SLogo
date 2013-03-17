package factory;

import java.util.List;
import model.Model;
import commands.ICommand;
import commands.Product;


public class ProductInitializer extends AbstractInitializer {

    public ProductInitializer (Model model, Parser parser) {
        super(model, parser);
        setNumArgs(Product.NUM_ARGS);
    }

    @Override
    protected ICommand instantiate (List<ICommand> parameters) {
        return new Product(parameters);
    }

}
