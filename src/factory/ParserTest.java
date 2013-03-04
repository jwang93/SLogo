package factory;

import commands.ICommand;
import exceptions.FormattingException;
import model.Model;

public class ParserTest {
    
    
    public static void main(String[] args){
        Parser parser = new Parser(new Model(null));
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
