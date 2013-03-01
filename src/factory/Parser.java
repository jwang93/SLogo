package factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import commands.ICommand;
import exceptions.FormattingException;


public class Parser {
    private Map<String, CommandInfo> myCommandMap;
    private Map<String, CommandInfo> myMathMap;
    private Map<String, Integer> myVariables = new HashMap<String, Integer>();

    public Parser () {
        ParserInitializer init = new ParserInitializer();
        myCommandMap = init.initializeMap();
    }

    public ICommand parse (String command) throws FormattingException {
        List<String> params = Arrays.asList(command.split("\\s+"));
        Iterator<String> iter = params.iterator();
        while (iter.hasNext()) {
            String keyword = iter.next();

            // get first string
            // test if in map (is command)
            // if not throw exception
            // else pull the infoclass in the map
            // loop over the numberof arguments (helper method)
            // use reflection with the classname and arguments to make command

            if (myCommandMap.containsKey(keyword)) {
                // then we are at the beginning of a command

                CommandInfo commandInfo = myCommandMap.get(keyword);
                String name = commandInfo.getName();
                int numArgs = commandInfo.getNumArgs();
                List<Integer> args = new ArrayList<Integer>();
                for (int i = 0; i < numArgs; i++) {
                    /*
                     * four cases:
                     * 1 keyword takes no parameters, followed by another command ex: penup fd 50
                     * 2 keyword followed by variable ex: fd :length
                     * 3 keyword followed by nested command ex: fd sum 10 10
                     * 4 Keyword followed brackets ex repeat 10 [ fd 50 left 50]
                     * 4 keyword followed by parameter ex: fd 50
                     * 5 keyword followed by incorect syntax ex: fd xyz
                     */
                    String parameter = iter.next();
                        // case 2
                    if (parameter.startsWith(":")) {
                        args.add(parseVariable(parameter));
                    }
                       // case 3
                    else if (myMathMap.containsKey(parameter)) {
                       // recurse to get returned math values
                    }
                    else if(isBracket( parameter)) {
                       // generate an collectioncommand to be passed into a control command like repeat
                    }
                       // case 5 parameter is an integer or command is wrong
                    else try {
                        args.add(Integer.parseInt(parameter));
                    }
                    catch (java.lang.NumberFormatException e) {
                        throw new FormattingException();
                    }
                }
                // make new command class with keyword and args
            }
            else {
                // command did not start a valid command
                throw new FormattingException();

            }

        }

        return null;
    }
    
    private ICommand parseMath(Iterator<String> iter){
        
        
        
        return null;
    }
    
    private boolean isBracket(String str){
        return str.equals("[") || str.equals("]");
    }

    private int parseVariable (String variable) throws FormattingException {
        variable = variable.substring(1);
        if (!myVariables.containsKey(variable))
            throw new FormattingException();
        return myVariables.get(variable);
    }

}
