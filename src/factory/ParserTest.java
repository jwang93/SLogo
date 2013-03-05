package factory;

import java.awt.Dimension;
import model.Model;
import commands.CommandList;
import commands.ICommand;
import exceptions.FormattingException;


public class ParserTest {
    private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";

    public static void main (String[] args) {

        Parser parser = new Parser(new Model(new Dimension()));
        try {
            ICommand test1 = parser.parse("fd 10 rt 90 fd 40");
            printICommand(test1);
            ICommand test2 = parser.parse("repeat 4 [ fd 100 rt 90 ]");
            printICommand(test2);
        }
        catch (FormattingException e) {
            e.printStackTrace();
        }
    }
    
    public static void printICommand (ICommand command) {
        CommandList print = (CommandList) command;
        print.printInfo();
    }
}
