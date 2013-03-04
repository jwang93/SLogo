package factory;

import model.Model;
import commands.ICommand;
import exceptions.FormattingException;


public class ParserTest {

    public static void main (String[] args) {
        Parser parser = new Parser(new Model());
        try {
            ICommand command = parser.parse("fd 50 rt 20");
            System.out.print(command);
        }
        catch (FormattingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
