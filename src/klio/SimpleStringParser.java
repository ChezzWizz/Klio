package klio;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Simple parsing object. Breaks a string down by non-word characters and adds each token to an
 * ArrayList. This object will also stitch together the command string into one string with a
 * specified separating character.
 * @author Chezz
 *
 */
public class SimpleStringParser {
    
    public ArrayList<String> command;
    
    /**
     * Initialize members.
     */
    public SimpleStringParser() {
        command = new ArrayList<String>();
    }
    
    /**
     * Breaks input string down by non-word characters.
     * @param str String to parse.
     * @return An array of string tokens.
     */
    public String[] parse(String str) {
        
        command.clear();
        
        str.toLowerCase();
        
        for (String s : str.split("\\W+")) {
            command.add(s);
        }
        
        return command.toArray(new String[1]);
    }
    
    /**
     * Stitch command back into one string with a default space separator. This will make one
     * string with each token separated by a space.
     * @return The newly formed string.
     */
    public String stitchCommand() {
        return stitchCommand(' ');
    }
    
    /**
     * Stitch command back into one string.
     * @param separator Separate each token with the specified character.
     * @return The newly formed string.
     */
    public String stitchCommand(char separator) {
        
        String str = "";
        
        Iterator<String> itr = command.iterator();
        for (;itr.hasNext();) {
            str += itr.next();
            if (itr.hasNext()) {
                str += separator;
            }
        }
        
        return str;
    }
}
