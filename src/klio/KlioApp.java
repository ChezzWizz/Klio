/***************************************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c)2015 Project klio.Klio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 **************************************************************************************************/


package klio;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * This class represents the application state and actions.
 *
 * Created by Chezz on 1/1/2016.
 */
public class KlioApp {

    public static final int GAME_STATE_LIMBO = 0;
    public static final int GAME_STATE_INITILIZING = 1;
    public static final int GAME_STATE_RUNNING = 2;
    public static final int GAME_STATE_CLOSING = 3;
    public static final int GAME_STATE_ERROR = -1;

    public static KlioApp instance = new KlioApp();
    public static int gameState = GAME_STATE_LIMBO;

    private static final String PROMPT = "~>";
    private String title;
    private Map<String, Action> verbMap;
    private boolean initialized;
    private Scanner keyboard;
    private AdventureFile adventureFile;

    public KlioApp() {
        gameState = GAME_STATE_INITILIZING;
        keyboard = new Scanner(System.in);
    }

    public void initialize() {

        ActionFactory.instance.initialize();

        PlayerCharacter.instance.initialize(adventureFile.getEntryPoint());

        if(ActionFactory.isInitialized() && PlayerCharacter.isInitialized()) {
            initialized = true;
        }

    }

    public void loadAdventureFile(String fileName) throws FileNotFoundException {
        adventureFile = new AdventureFile(fileName);
    }

    public void start() {

        initialize();

        if(initialized) {
            gameState = GAME_STATE_RUNNING;
        }

        while(gameState == GAME_STATE_RUNNING) {

            System.out.print(PROMPT + " ");
            Command cmd = getCommand();
            processCommand(cmd);

        }

    }

    private Command getCommand() {

        String rawInput = keyboard.nextLine();

        String[] parsedInput = rawInput.split("\\s");

        if(parsedInput.length < 2) {
            return new Command(parsedInput[0], null);
        }

        return new Command(parsedInput[0], parsedInput[1]);
    }

    private void processCommand(Command c) {

        // TODO: Process verb based on verb mapping
        //      * Check the object context first.
        //      * Check the global object second.

        // This is for testing only
        ActionFactory.instance.getAction(c.getVerb()).execute(new TextObject("text", "Some text."));

    }

}
