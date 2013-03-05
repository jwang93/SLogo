package factory;

import java.awt.Dimension;
import model.Model;
import commands.ICommand;
import exceptions.FormattingException;


public class ParserTest {
    private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";

    public static void main (String[] args) {

        Parser parser = new Parser(new Model(new Dimension()));
        try {
            ICommand main = parser.parse("make :variable 10 repeat 2 [ fd 10 sum 10 sum 10 10 ]");
            System.out.println(main);
        }
        catch (FormattingException e) {
            e.printStackTrace();
        }
    }
}
