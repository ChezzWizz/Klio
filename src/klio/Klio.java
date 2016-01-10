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


import java.io.File;
import java.nio.file.Paths;

 /**
 * This is the main application class. Handles command line options, creates application object, and
 * starts the main game loop.
 *
 * Created by Chezz on 1/1/2016.
 */
public class Klio {
    public static void main(String[] args) {
        // TODO: Parse any commandline switches
        //      Possible switches:
        //          -a <adventure_filename>

        File adventureFile = null;

        // if an adventure file is passed as an argument then set the file to the arguments
        //  parameter. Otherwise, set the file to a default adventure file or show an error.
        if (args.length > 0) {
            if (args[0].equals("-a")) {
                adventureFile = new File(args[1]);
            } else {
                System.out.println("Unrecognized argument: " + args[0]);
                System.exit(-1);
            }
        } else {
            adventureFile = new File("default_adventure.kaf");
        }

        // Start the application
        KlioApp app = new KlioApp(adventureFile);
        app.startGame();
    }
}
