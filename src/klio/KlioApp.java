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

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the application state and actions.
 *
 * Created by Chezz on 1/1/2016.
 */
public class KlioApp {

    private static final int GAME_STATE_INITILIZING = 0;
    private static final int GAME_STATE_RUNNING = 1;
    private static final int GAME_STATE_CLOSING = 3;
    private static final int GAME_STATE_ERROR = -1;

    private static final String PROMPT = "~>";
    private AdventureFile gameFile;
    private String title;
    private Map<String, Action> verbMap;
    private int gameState;
    private boolean initialized;

    public KlioApp(File adventureFile) {
        gameState = GAME_STATE_INITILIZING;
        gameFile = new AdventureFile(adventureFile);
    }

    public void init() {


        initialized = true;
    }

    public void start() {
        if(initialized) {
            gameState = GAME_STATE_RUNNING;
        }

        while(gameState == GAME_STATE_RUNNING) {

            System.out.println(PROMPT);
            Command cmd = getCommand();
            processCommand(cmd);

        }

    }

    private Command getCommand() {
        return new Command("test", "this");
    }

    private void processCommand(Command c) {

    }

}
