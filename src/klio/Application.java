package klio;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Application {

    private final int INIT = 0;
    private final int RUNNING = 1;
    private final int ERROR = -1;
    
    private static Application _instance = null;

    private int _gameState = INIT; 

    /**
     * Private application constructor for singleton instance.
     */
    private Application() {
        _gameState = 1; // running
    }

    /**
     * Get the singleton object.
     * @return The static singleton object
     */
    public static Application getInstance() {
        if (_instance == null) {
            _instance = new Application();
        }

        return _instance;
    }

    /**
     * Main application loop.
     * 
     * @return Non zero on error.
     */
    public int Run() {

        SimpleStringParser parser = new SimpleStringParser();
        PrintStream out = System.out;
        String prompt = "> ";
        Scanner keyboard = new Scanner(System.in);
        
        // If the game state remains as 1 (Running) then continue printing out text and displaying
        // the prompt.
        while (_gameState == RUNNING)
        {
            // Print text and pompt
            out.println();
            out.println("Text will be here. Lorem ipsum dolor sit amet, consectetur adipiscing"
                    + "elit. In egestas odio sed tortor elementum egestas. Etiam volutpat eros"
                    + "dignissim, pellentesque velit eu, dictum ante. Quisque lacus enim, egestas"
                    + "in tellus non, congue elementum diam. Integer lorem ligula, suscipit sed "
                    + "enim non, dignissim gravida turpis. Mauris id diam ut turpis consequat"
                    + "imperdiet quis ut ligula. Sed pellentesque commodo felis vel cursus.");
            out.println();
            out.print(prompt);
            
            // Parse the command using the SimpleParser
            String command = keyboard.nextLine();
            parser.parse(command);
            
            // Print out the parsed command as a group of strings.
            out.print("{ ");            
            Iterator<String> itr = parser.command.iterator();
            for (String s = null; itr.hasNext();) {
                s = itr.next();
                out.print(s);
                if (itr.hasNext()) {
                    out.print(", ");
                }
            }
            out.print(" }");
            out.println();            
            
            // Tie the command strings back together using the default ' ' character.
            String joinedCommand = parser.stitchCommand();
            
            // Print out the stitched command as a single string.
            out.print("\"");
            out.print(joinedCommand);
            out.print("\"");
            out.println();
            
            // Check for the "exit" or "quit" command.
            if (joinedCommand.equals("exit") || joinedCommand.equals("quit")) {
                keyboard.close();
                return 0; // Clean exit.
            }
        }

        keyboard.close();
        return ERROR; // This should not be reached.
    }
}
