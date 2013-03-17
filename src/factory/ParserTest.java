package factory;

import java.awt.Dimension;
import model.Model;
import commands.ICommand;
import exceptions.FormattingException;


public class ParserTest {
    private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";

    public static void main (String[] args) {
        Model model = new Model(new Dimension(600, 400));
        Parser parser = new Parser(model);
        try {

            String command = "sum 10 sum 10 10 ";

            ICommand main = parser.parse(command);
            System.out.println(main);
            
            //TEST CASES 
            System.out.println("TEST CASES: ");
            model.executeCommand("repeat 4 [ fd sum 30 random 10 ]");
            model.executeCommand("back 100 rt 90");

        }
        catch (FormattingException e) {
            e.printStackTrace();
        }
    }
}
