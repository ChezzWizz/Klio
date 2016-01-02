/***************************************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c)2015 Project Klio
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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the application state and actions.
 *
 * Created by Chezz on 1/1/2016.
 */
public class KlioApp {
    private final String _PROMPT = "~>";

    private File _adventureFile;
    private Map<Integer, String> _sceneMap;
    private PlayerCharacter _pc;
    private Scene _currentScene;

    public KlioApp(File adventureFile) {
        _sceneMap = new HashMap<>();

        // TODO: Load the adventure file
        //  * Add each scene from the file into the scene map.
    }

    public void startGame() {
        // TODO: Start the primary game loop
        //  * Get a player character to use
        //  * Start displaying scenes followed by a prompt
        //  * Get user input and display a new scene
    }

    private void createCharacter() {
        // TODO: tart a loop that populates a player character

        // Use D20 character traits. Basic attributes should be enough to calculate the rest of the
        // character.
    }

    private void processCommandStr(String command, Integer currentScene) {
        // TODO: Interpret the command string
        // Either run a sub process, such as a battle sequence, or modify the currentScene object to
        // contain the id of the next scene to print for the user.
    }

    private void startBattleSequence(int npcId) {
        // TODO: Execute a loop that runs through the battle sequence with the specified NPC
    }
}
